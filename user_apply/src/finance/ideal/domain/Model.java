package finance.ideal.domain;

/**
 * 模型介绍
 */
public class Model {

    private String id;
    private String modelname;//模型名称
    private String introduce;//模型介绍介绍
    private String images;//图片地址
    private String time;//配置完成时间
    private String modelmanufacturer;//模型制造者
    private String datainput;//输入的数据
    private String modeldata;//输出碰撞之后返回的标签
    private String modelinterface;//需要提供的接口
    private String dataselect;//可选择的数据源
    private String modelintroducedetail;//模型详细介绍

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", modelname='" + modelname + '\'' +
                ", introduce='" + introduce + '\'' +
                ", images='" + images + '\'' +
                ", time='" + time + '\'' +
                ", modelmanufacturer='" + modelmanufacturer + '\'' +
                ", datainput='" + datainput + '\'' +
                ", modeldata='" + modeldata + '\'' +
                ", modelinterface='" + modelinterface + '\'' +
                ", dataselect='" + dataselect + '\'' +
                ", modelintroducedetail='" + modelintroducedetail + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
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

    public String getModelmanufacturer() {
        return modelmanufacturer;
    }

    public void setModelmanufacturer(String modelmanufacturer) {
        this.modelmanufacturer = modelmanufacturer;
    }

    public String getDatainput() {
        return datainput;
    }

    public void setDatainput(String datainput) {
        this.datainput = datainput;
    }

    public String getModeldata() {
        return modeldata;
    }

    public void setModeldata(String modeldata) {
        this.modeldata = modeldata;
    }

    public String getModelinterface() {
        return modelinterface;
    }

    public void setModelinterface(String modelinterface) {
        this.modelinterface = modelinterface;
    }

    public String getDataselect() {
        return dataselect;
    }

    public void setDataselect(String dataselect) {
        this.dataselect = dataselect;
    }

    public String getModelintroducedetail() {
        return modelintroducedetail;
    }

    public void setModelintroducedetail(String modelintroducedetail) {
        this.modelintroducedetail = modelintroducedetail;
    }
}
