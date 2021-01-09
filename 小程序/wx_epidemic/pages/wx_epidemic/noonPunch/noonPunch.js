// pages/wx_epidemic/today/today.js
var util = require('../../../utils/date.js');
Page({
  /**
   * 页面的初始数据
   */
  data: {
    date: '2020-05-01',
    index: null,
    picker: ['计算机工程学院', '商学院', '通信工程学院', '电子工程学院', '电气工程学院'],
    ip1: "https://xtdyq.petchk.cn"
  },
  //学院选择
  PickerChange(e) {
    console.log(e);
    this.setData({
      index: e.detail.value
    })
  },

  //信息提交
  formSubmit(e) {
    var that = this;
    // 首先判定时间是否在填报时间以内
    // 6: 00 到10: 00 打一次卡      11:00 到 13:00打一次卡      19: 00 到22: 00 打一次卡
    var timestamp = Date.parse(new Date());
    var date = new Date(timestamp);
    console.log(date.getHours());
    // if (date.getHours() < 13 || date.getHours() > 11) {
    //     this.setData({
    //         modalName: "Modal",
    //         info: "请在规定时间内打卡"
    //     })
    //     return;
    // }

    // 获取表单数据
    let {
      name,
      sid,
      clas,
      grade,
      major,
      counselor_name,
      phone,
      dormitory,
      dormitory_no,
      is_danger_region,
      is_touch_danger_region,
      is_arrive_danger_region,
      is_touch_patient,
      is_illness,
      living_together,
      is_relative_quarantine,
      is_touch_outlands,
      temperature
    } = e.detail.value;
    //获取picker值

    var college = that.data.picker[that.data.index == (null || "") ? 0 : that.data.index];
    console.log('form发生了submit事件，携带数据为：' +
      name,
      sid,
      clas,
      grade,
      major,
      counselor_name,
      phone,
      dormitory,
      dormitory_no,
      is_danger_region,
      is_touch_danger_region,
      is_arrive_danger_region,
      is_touch_patient,
      is_illness,
      living_together,
      is_relative_quarantine,
      is_touch_outlands,
      temperature,
      college
    );

    //如果遗漏信息
    if (!name
      || !sid
      || !clas
      || !grade
      || !major
      || !counselor_name
      || !temperature
      || !phone
      || !dormitory
      || !dormitory_no
      || !is_danger_region
      || !is_touch_danger_region
      || !is_arrive_danger_region
      || !is_touch_patient
      || !is_illness
      || !living_together
      || !is_relative_quarantine
      || !is_touch_outlands) {
      this.setData({
        modalName: "Modal",
        info: "请勿遗漏信息"
      })
      return;
    }

    wx.request({
      url: that.data.ip1 + "/temperatureReport",
      data: {
        name: name,
        sid: sid,
        clas: clas,
        grade: grade,
        major: major,
        college: college,
        counselor_name: counselor_name,
        phone: phone,
        dormitory: dormitory,
        dormitory_no: dormitory_no,
        is_danger_region: is_danger_region,
        is_touch_danger_region: is_touch_danger_region,
        is_arrive_danger_region: is_arrive_danger_region,
        is_touch_patient: is_touch_patient,
        is_illness: is_illness,
        living_together: living_together,
        is_relative_quarantine: is_relative_quarantine,
        is_touch_outlands: is_touch_outlands,
        temperature: temperature
      },
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        var code = res.data.code;
        var msg = res.data.msg;
        console.log(res.data);
        if (code == 200) {
          that.setData({
            modalName: "DialogModal1",
            info: "填报成功"
          })
        } else if (code == 405) {
          if (msg == "unknown error") {
            that.setData({
              modalName: "DialogModal1",
              info: "网络错误,请稍后再试,或者联系管理员"
            })
          }

          if (msg == "out of time") {
            that.setData({
              modalName: "DialogModal1",
              info: "网络服务未开放,请在规定时间内填报"
            })
          }

          if (msg == "moring repeat") {
            that.setData({
              modalName: "DialogModal1",
              info: "早间已经填报过,请勿重复填报"
            })
          }

          if (msg == "noon repeat") {
            that.setData({
              modalName: "DialogModal1",
              info: "午间已经填报过,请勿重复填报"
            })
          }

          if (msg == "evening repeat") {
            that.setData({
              modalName: "DialogModal1",
              info: "晚间已经填报过,请勿重复填报"
            })
          }
        } else {
          that.setData({
            modalName: "DialogModal1",
            info: "网络异常"
          })
        }
        wx.reLaunch({
          url: '/pages/home/home',
        })
      }
    })
  },

  // 关闭窗口
  hideModal(e) {
    this.setData({
      modalName: null
    })
  },

  onLoad: function (options) {
    //提前拿取本地缓存
    this.setData({
      name: wx.getStorageSync('yq_name'),
      sid: wx.getStorageSync('yq_sid'),
      clas: wx.getStorageSync('yq_clas'),
      grade: wx.getStorageSync('yq_grade'),
      major: wx.getStorageSync('yq_major'),
      counselor_name: wx.getStorageSync('yq_counselor_name'),
      phone: wx.getStorageSync('yq_phone'),
      dormitory: wx.getStorageSync('yq_dormitory'),
      dormitory_no: wx.getStorageSync('yq_dormitory_no'),
      college: wx.getStorageSync('yq_college'),
      index: wx.getStorageSync('yq_index')
    })
  },
})