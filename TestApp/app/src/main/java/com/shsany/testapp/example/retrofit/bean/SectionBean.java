package com.shsany.testapp.example.retrofit.bean;

import java.util.List;

/**
 * Created by PC on 2018/1/8.
 *
 * 部门实体类
 */

public class SectionBean {

    /**
     * data : [{"bmbm":"02",
     *          "bmmc":"大阳煤矿 ",
     *          "bmrend":0,
     *          "bmrens":0,
     *          "bmrenu":0,
     *          "bmtype":0,
     *          "sjbm":"02"},
     *         {"bmbm":"0201 ",
     *          "bmmc":"上级领导",
     *          "bmrend":0,
     *          "bmrens":0,
     *          "bmrenu":0,
     *          "bmtype":0,
     *          "sjbm":"02"},
     *         {"bmbm":"0202",
     *          "bmmc":"通风科
     *          ","bmrend":0,
     *          "bmrens":0,
     *          "bmrenu":0,
     *          "bmtype":0,
     *          "sjbm":"02"},
     *         {"bmbm":"0203",
     *          "bmmc":"材管组
     *          ","bmrend":0,
     *          "bmrens":0,
     *          "bmrenu":0,
     *          "bmtype":0,
     *          "sjbm":"02"},
     *         {"bmbm":"0204","bmmc":"生产技术科","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0206","bmmc":"调度室","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0207","bmmc":"职业危害防治科","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0211","bmmc":"机电二队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0212","bmmc":"机电科","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0213","bmmc":"机电一队 ","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0214","bmmc":"机修厂","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0217","bmmc":"安全科","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0218","bmmc":"开拓队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0220","bmmc":"矿级领导","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0223","bmmc":"瓦斯抽采队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0227","bmmc":"地测科","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0230 ","bmmc":"探放水队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0239","bmmc":"运输队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0243","bmmc":"安全质量标准化办公室","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0244","bmmc":"综放二队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0245","bmmc":"综放一队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0246","bmmc":"综掘二队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02 "},
     *         {"bmbm":"0247","bmmc":"综掘一队 ","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0248","bmmc":"总工办","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02 "},
     *         {"bmbm":"0249","bmmc":"瓦斯员","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02 "},
     *         {"bmbm":"0250","bmmc":"安全员","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0251","bmmc":"机电三队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0253","bmmc":"信息中心 ","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02 "},
     *         {"bmbm":"0256","bmmc":"管理人员","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0260","bmmc":"矿山救护队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0261","bmmc":"通风维修队","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0262","bmmc":"瓦斯抽采科","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0263","bmmc":"厂家技术人员","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":0,"sjbm":"02"},
     *         {"bmbm":"0264","bmmc":"职工医院","bmrend":0,"bmrens":0,"bmrenu":0,"bmtype":4,"sjbm":"02"}]
     * message :
     * state : 0
     */

    private String message;
    private int state;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bmbm : 02
         * bmmc : 大阳煤矿
         * bmrend : 0
         * bmrens : 0
         * bmrenu : 0
         * bmtype : 0
         * sjbm : 02
         */

        private String bmbm;
        private String bmmc;
        private int bmrend;
        private int bmrens;
        private int bmrenu;
        private int bmtype;
        private String sjbm;

        public String getBmbm() {
            return bmbm;
        }

        public void setBmbm(String bmbm) {
            this.bmbm = bmbm;
        }

        public String getBmmc() {
            return bmmc;
        }

        public void setBmmc(String bmmc) {
            this.bmmc = bmmc;
        }

        public int getBmrend() {
            return bmrend;
        }

        public void setBmrend(int bmrend) {
            this.bmrend = bmrend;
        }

        public int getBmrens() {
            return bmrens;
        }

        public void setBmrens(int bmrens) {
            this.bmrens = bmrens;
        }

        public int getBmrenu() {
            return bmrenu;
        }

        public void setBmrenu(int bmrenu) {
            this.bmrenu = bmrenu;
        }

        public int getBmtype() {
            return bmtype;
        }

        public void setBmtype(int bmtype) {
            this.bmtype = bmtype;
        }

        public String getSjbm() {
            return sjbm;
        }

        public void setSjbm(String sjbm) {
            this.sjbm = sjbm;
        }
    }
}
