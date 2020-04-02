package com.example.lliziyan20200320.Order0402.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderListBean implements Serializable {
    public String expressCompName;
    public int orderStatus;
    public String orderId;
    public ArrayList<DetailListBean> detailList;
}
