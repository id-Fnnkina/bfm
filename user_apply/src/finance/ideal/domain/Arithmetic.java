package finance.ideal.domain;

/**
 * 算法
 */
public class Arithmetic {

    private String id;
    private String arithmeticname;//模型名称
    private String introduce;//模型介绍介绍
    private String images;//图片地址
    private String time;//配置完成时间

    @Override
    public String toString() {
        return "Arithmetic{" +
                "id='" + id + '\'' +
                ", arithmeticname='" + arithmeticname + '\'' +
                ", introduce='" + introduce + '\'' +
                ", images='" + images + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArithmeticname() {
        return arithmeticname;
    }

    public void setArithmeticname(String arithmeticname) {
        this.arithmeticname = arithmeticname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

