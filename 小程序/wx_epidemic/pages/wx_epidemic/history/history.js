import { parsePath } from "history";

// pages/wx_epidemic/history/history.js
const app = getApp()
Page({
    data: {
        StatusBar: app.globalData.StatusBar,
        CustomBar: app.globalData.CustomBar,
        Custom: app.globalData.Custom,
        TabCur: 0,
        MainCur: 0,
        VerticalNavTop: 0,
        load: true,
        ip1: "https://xtdyq.petchk.cn",
        //测试数据
        record: [{
                id: '0',
                date: '05-01',
                week: '星期五',
                stuname: '李隆青',
                number: '19250121',
                place: '网工',
                teacher_name: '辅导员',
                morning_temperature: '36.2',
                evening_temperature: '36.3'
            },
            {
                id: '1',
                date: '05-02',
                week: '星期六',
                stuname: '李隆青',
                number: '19250121',
                place: '网工',
                teacher_name: '辅导员',
                morning_temperature: '36.2',
                evening_temperature: '36.3'
            },
            {
                id: '2',
                date: '05-03',
                week: '星期日',
                stuname: '李隆青',
                number: '19250121',
                place: '网工',
                teacher_name: '辅导员',
                morning_temperature: '36.2',
                evening_temperature: '36.3'
            },
            {
                id: '3',
                date: '05-04',
                week: '星期一',
                stuname: '李隆青',
                number: '19250121',
                place: '网工',
                teacher_name: '辅导员',
                morning_temperature: '36.2',
                evening_temperature: '36.3'
            },
            {
                id: '4',
                date: '05-05',
                week: '星期二',
                stuname: '李隆青',
                number: '19250121',
                place: '网工',
                teacher_name: '辅导员',
                morning_temperature: '36.2',
                evening_temperature: '36.3'
            },
            {
                id: '5',
                date: '05-06',
                week: '星期三',
                stuname: '李隆青',
                number: '19250121',
                place: '网工',
                teacher_name: '辅导员',
                morning_temperature: '36.2',
                evening_temperature: '36.3'
            },
            {
                id: '6',
                date: '05-07',
                week: '星期四',
                stuname: '李隆青',
                number: '19250121',
                place: '网工',
                teacher_name: '辅导员',
                morning_temperature: '36.2',
                evening_temperature: '36.3'
            },
        ],
    },

    onReady() {
        wx.hideLoading()
    },
    tabSelect(e) {
        this.setData({
            TabCur: e.currentTarget.dataset.id,
            MainCur: e.currentTarget.dataset.id,
            VerticalNavTop: (e.currentTarget.dataset.id - 1) * 50
        })
    },
    VerticalMain(e) {
        let that = this;
        let record = that.data.record;
        let tabHeight = 0;
        if (this.data.load) {
            for (let i = 0; i < record.length; i++) {
                let view = wx.createSelectorQuery().select("#main-" + record[i].id);
                view.fields({
                    size: true
                }, data => {
                    record[i].top = tabHeight;
                    tabHeight = tabHeight;
                    record[i].bottom = tabHeight;
                }).exec();
            }
            that.setData({
                load: false,
                record: record
            })
        }
        let scrollTop = e.detail.scrollTop + 20;
        for (let i = 0; i < record.length; i++) {
            if (scrollTop > record[i].top && scrollTop < record[i].bottom) {
                that.setData({
                    VerticalNavTop: (record[i].id - 1) * 50,
                    TabCur: record[i].id
                })
                return false
            }
        }
    },


    onLoad: function(options) {
        var that = this;
        if (wx.getStorageSync('yq_sid') == "") {
            wx.navigateTo({
                url: '../../../pages/wx_epidemic/information/information',
            })
            console.log("本地缓存的学号" + wx.getStorageSync('yq_sid'));
        } else {
            var sid = wx.getStorageSync('yq_sid');
            wx.request({
              url: that.data.ip1 + "/seven/info",
                data: {
                    sid: sid
                },
              method: 'POST',
              header: {
                "Content-Type": "application/x-www-form-urlencoded"
              },
                success: function(res) {
                    that.setData({
                        record: res.data.data
                    })
                }
            })
        }
    },
})