// pages/wx_epidemic/information/information.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
   
        index: null,
        picker: ['计算机工程学院', '商学院', '通信工程学院', '电子工程学院', '电气工程学院'],
    },

    //跳出编辑模态框
    editInfo(e) {
        this.setData({
            modalName: "editModal1"
        })
    },

    // 关闭窗口
    hideModal(e) {
        this.setData({
            modalName: null
        })
    },

    //学院选择
    PickerChange(e) {
        console.log(e);
        this.setData({
            index: e.detail.value
        })
        wx.setStorageSync('yq_index', e.detail.value);
    },


    //信息提交
    formPreserve(e) {
        var that = this;
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
        } = e.detail.value;
        //获取picker值
        var college = that.data.picker[that.data.index == null ? 0 : that.data.index];

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
            college
        );

        //如果遗漏信息
        if (!name || !sid || !clas || !grade || !major ||
            !phone || !dormitory || !dormitory_no ||
            !counselor_name) {
            this.setData({
                modalName: "Modal",
                info: "请勿遗漏信息"
            })
            return;
        }

        that.setData({
            name: name,
            sid: sid,
            clas: clas,
            grade: grade,
            major: major,
            counselor_name: counselor_name,
            phone: phone,
            dormitory: dormitory,
            dormitory_no: dormitory_no,
            college: college
        })

        //将学生信息缓存在本地
        wx.setStorageSync('yq_name', name);
        wx.setStorageSync('yq_sid', sid);
        wx.setStorageSync('yq_clas', clas);
        wx.setStorageSync('yq_grade', grade);
        wx.setStorageSync('yq_major', major);
        wx.setStorageSync('yq_counselor_name', counselor_name);
        wx.setStorageSync('yq_phone', phone);
        wx.setStorageSync('yq_dormitory', dormitory);
        wx.setStorageSync('yq_dormitory_no', dormitory_no);
        wx.setStorageSync('yq_college', college);

        console.log("缓存的信息" +
            wx.getStorageSync('yq_name'),
            wx.getStorageSync('yq_sid'),
            wx.getStorageSync('yq_clas'),
            wx.getStorageSync('yq_grade'),
            wx.getStorageSync('yq_major'),
            wx.getStorageSync('yq_counselor_name'),
            wx.getStorageSync('yq_phone'),
            wx.getStorageSync('yq_dormitory'),
            wx.getStorageSync('yq_dormitory_no'),
            wx.getStorageSync('yq_college')
        )

        that.hideModal();
    },

    onLoad: function(options) {
        //如果没有记录过自己的信息就记录
        if (wx.getStorageSync('yq_sid') == "") {
            this.setData({
                modalName: "editModal1"
            })
        }

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
            college: wx.getStorageSync('yq_college')
        })
    },
})