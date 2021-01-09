// pages/wx_epidemic/guide/guide.js
Page({

    data: {
        //测试数据
        name: '',
        sid:'',
        cardCur: 0,
        //轮播图测试数据
        swiperList: [{
          id: 0,
          type: 'image',
          url: 'https://api.sliber.cn/images/banner0508.jpg'
        }, {
          id: 1,
            type: 'image',
            url: 'https://api.sliber.cn/images/banner0508-1.jpg',
        }
        ],
    },
    copyText: function (e) {
        console.log(e)
        wx.setClipboardData({
          data: e.currentTarget.dataset.text,
          success: function (res) {
            wx.getClipboardData({
              success: function (res) {
                wx.showToast({
                  title: '复制成功'
                })
              }
            })
          }
        })
      },
    //轮播图
    cardSwiper(e) {
        this.setData({
          cardCur: e.detail.current
        })
      },
    //跳转页面
    toMonringBtn() {
        wx.navigateTo({
            url: '../../../pages/wx_epidemic/moringPunch/moringPunch',
        })
    },
  toNoonBtn() {
    wx.navigateTo({
      url: '../../../pages/wx_epidemic/noonPunch/noonPunch',
    })
  },
    toEveningBtn() {
        wx.navigateTo({
            url: '../../../pages/wx_epidemic/eveningPunch/eveningPunch',
        })
    },
    tohistoryBtn() {
        wx.navigateTo({
            url: '../../../pages/wx_epidemic/history/history',
        })
    },
    toinformationBtn() {
        wx.navigateTo({
            url: '../../../pages/wx_epidemic/information/information',
        })
    },

    onLoad: function(options) {
        if (wx.getStorageSync('yq_sid') == "") {
            wx.navigateTo({
                url: '../../../pages/wx_epidemic/information/information',
            })
            console.log("本地缓存的学号" + wx.getStorageSync('yq_sid'));
        };
        this.setData({
            name: wx.getStorageSync('yq_name'),
            sid: wx.getStorageSync('yq_sid'),
        })
    },
    onShow: function(options) {
        this.setData({
            name: wx.getStorageSync('yq_name'),
            sid: wx.getStorageSync('yq_sid'),
        })
    }
})