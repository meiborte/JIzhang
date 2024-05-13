package com.meiborte.www;

/**
 * @Author ZhangKaiYuan
 * @Date 2023/9/19 15:34
 *
 * 创建一个账号类，用来存储账号信息
 */
public class Account {
    //类别
    String classify;
    //账户
    String accout;
    //类型
    String sorts;
    //金额
    double money;
    //时间
    String time;
    //备注
    String remark;

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public String getSort() {
        return sorts;
    }

    public void setSort(String sort) {
        this.sorts = sort;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Account() {
    }

    public Account(String classify, String accout, String sorts, double money, String time, String remark) {
        this.classify = classify;
        this.accout = accout;
        this.sorts = sorts;
        this.money = money;
        this.time = time;
        this.remark = remark;
    }
}