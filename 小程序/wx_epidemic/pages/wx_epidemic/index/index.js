// pages/wx_epidemic/index/index.js

Page({
  data: {
    cardCur: 0,
    //轮播图测试数据
    swiperList: [{
      id: 0,
      type: 'image',
      url: 'https://www.dqdxz.xyz/imageList/yq1.jpg'
    }, {
      id: 1,
        type: 'image',
        url: 'https://www.dqdxz.xyz/imageList/yq2.jpeg',
    }, {
      id: 2,
      type: 'image',
      url: 'https://www.dqdxz.xyz/imageList/yq3.jpeg'
    }],
  },
  // 轮播图
  cardSwiper(e) {
    this.setData({
      cardCur: e.detail.current
    })
  },
  guideBtn(){
    wx.navigateTo({
    url: '../../../pages/wx_epidemic/guide/guide',
  })}
  
})