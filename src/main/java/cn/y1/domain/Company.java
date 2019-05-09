package cn.y1.domain;

public class Company {
    private String companyname;//生产公司名称
    private String proseries;//产品批次号
    private String testmeth;//送检方式
    private String bookingdate;//预约日期
    private int testnum;//送检件数
    private String address;//地址
    private String result;//查询结果
    private  String code;//查询码

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getProseries() {
        return proseries;
    }

    public void setProseries(String proseries) {
        this.proseries = proseries;
    }

    public String getTestmeth() {
        return testmeth;
    }

    public void setTestmeth(String testmeth) {
        this.testmeth = testmeth;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public int getTestnum() {
        return testnum;
    }

    public void setTestnum(int testnum) {
        this.testnum = testnum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
