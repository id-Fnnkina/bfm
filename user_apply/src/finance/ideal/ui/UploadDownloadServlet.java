package finance.ideal.ui;

import finance.ideal.daoImpl.*;
import finance.ideal.domain.*;
import finance.ideal.util.ExcelOperaation;
import finance.ideal.util.FileWriteAndReaderUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 小额贷款选择业务的下载文件
 */

@MultipartConfig
public class UploadDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String method = req.getParameter("method");
        String methodid = req.getParameter("methodid");
        switch (method) {
            case "downloadfile":
                System.out.println("正在进行小额贷款信息文件下载");
                doDownFile(req,resp,methodid);
                break;
            case "downloadmodel":
                System.out.println("正在进行小额贷款导入模板文件下载");
                doDownModel(req,resp,"test/dodownpersonalloanmodelfile.xls",method);
                break;
            case "downnetloadmodel":
                System.out.println("正在进行网贷平台风险评估业务导入模板文件下载");
                doDownModel(req,resp,"test/downnetloadmodelfile.xls",method);
                break;
            case "downenterprisemodel":
                System.out.println("正在进行企业经营风险评估业务导入模板文件下载");
                doDownModel(req,resp,"test/downenterprisemodelfile.xls",method);
                break;
            case "downpersonaloperatormodel":
                System.out.println("正在进行个人运营商信用风险评估业务导入模板文件下载");
                doDownModel(req,resp,"test/dodownpersonaloperatormodelfile.xls",method);
                break;
            case "downpersonalloanmodel":
                System.out.println("正在进行个人贷款信用评估业务导入模板文件下载");
                doDownModel(req,resp,"test/dodownpersonalloanmodelfile.xls",method);
                break;

            case "downloadworkbase":
                System.out.println("正在进行金融风控列表下载");
                doDownWorkbase(req,resp);
                break;
            case "downloadbusinesslist":
                System.out.println("正在进行业务记录报表下载");
                doDownBusinessList(req,resp);
                break;
            case "downloachaincode":
                System.out.println("正在进行区块链记录报表下载");
                doDownChainCode(req,resp);
                break;
            case "downloadchaincodemodel":
                System.out.println("正在进行区块链模型记录报表下载");
                doDownChainCodeModel(req,resp);
                break;
            case "downloadlog":
                System.out.println("正在进行日志报表下载");
                doDownLog(req,resp);
                break;
            case "downloadp2ploan":
                System.out.println("正在进行区块链记录报表下载");
                doDownP2PLoan(req,resp);
                break;
            default:
                System.out.println("ERROR!");
                break;

        }

    }

    /**
     * 小额贷款信息文件下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doDownFile(HttpServletRequest req, HttpServletResponse resp,String methodid) throws ServletException, IOException {
        String batchno = req.getParameter("id");
        String path=this.getServletContext().getRealPath("test/test.xls");
        PrettyLoanImpl pl = new PrettyLoanImpl();//小额贷款业务类
        pl.BusinessPrettyWrite(batchno,path,methodid);// 将文件写入文件newTemp.txt
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//读写文件工具类
        fwr.downloadxls(req, resp, "prettyloan.jsp", batchno,path);
    }

    /**
     * 业务记录报表下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doDownBusinessList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
//        String leader = req.getParameter("str_leader");
        String path=this.getServletContext().getRealPath("test/testfile.txt");
        BusinessLIstImpl businessLIst = new BusinessLIstImpl();
        List<BusinessList> businessLists = businessLIst.SendData(id);
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件的读写对象
        String business="";
        int j=1;
        for (int i = 0; j < businessLists.size()+1; i++) {
            j++;
            BusinessList detail = businessLists.get(i);
            business+=j+","+detail.getBusinessId()+","+detail.getId()+","+detail.getBusinessLeader()+","+detail.getEvModel()+","+detail.getBusinessTime()+","+detail.getBusinessDataUse()+","
                    +detail.getBusinessDataSuc()+","+detail.getBusinessSendTime()+"\n";
        }
        fwr.appendMethodB(path,business);
        fwr.download(req, resp, "businesslist.jsp", "Businesslist",path);
    }

    /**
     * 金融风控列表下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doDownWorkbase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WorkBaseImpl workBase = new WorkBaseImpl();
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String path=this.getServletContext().getRealPath("test/test.xls");
        workBase.SendWorkBaseListWriteData(path,startTime,endTime);// 将文件写入文件newTemp.txt
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//读写文件工具类
        fwr.downloadxls(req, resp, "workplace.jsp", "WorkBase",path);
    }

    /**
     * 智能合约拉取数据报表下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doDownChainCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String BusinessNumber = req.getParameter("BusinessNumber");
        String path=this.getServletContext().getRealPath("test/test.xls");
        ChainCodeImpl chainCode = new ChainCodeImpl();
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//读写文件工具类、
        ExcelOperaation excelOperaation = new ExcelOperaation();
        List<String[]> result = new ArrayList<String[]>();
        String[] title={"业务ID","名称","上链时间","银行卡号","模型id","结果hash值","电话","业务序列号","数据源类型","身份证号","业务类型"};
        List<ChainCodeDomain> chainCodeDomains;
        if (BusinessNumber.isEmpty()||BusinessNumber.equals("null")){
            chainCodeDomains = chainCode.SendChainCodeData();// 将文件写入文件newTemp.txt
        }else {
            chainCodeDomains=chainCode.SendSelectChainCodeData(BusinessNumber);
        }

        String chainCodeFile="";
        for (int i = 0; i < chainCodeDomains.size(); i++) {
            ChainCodeDomain chainCodeDomain = chainCodeDomains.get(i);
            String[] values = {chainCodeDomain.getRecordId(),chainCodeDomain.getRealName(),chainCodeDomain.getVerifyDate(),chainCodeDomain.getBankCard(),
                    chainCodeDomain.getHashData(),chainCodeDomain.getMobile(),chainCodeDomain.getTxId(),chainCodeDomain.getBusinessNumber(),
                    chainCodeDomain.getSource(),chainCodeDomain.getIdNo(),chainCodeDomain.getBusinessTypeId()};
//            chainCodeFile+=chainCodeDomain.getRecordId()+","+chainCodeDomain.getRealName()+","+chainCodeDomain.getVerifyDate()+","+chainCodeDomain.getBankCard()
//                    +","+chainCodeDomain.getHashData()+","+chainCodeDomain.getMobile()+","+chainCodeDomain.getTxId()+","+chainCodeDomain.getBusinessNumber()
//                    +","+chainCodeDomain.getRemark()+","+chainCodeDomain.getSource()+","+chainCodeDomain.getIdNo()+","+chainCodeDomain.getBusinessTypeId()
//                    +","+chainCodeDomain.getCompanyName()+"\n";
            result.add(values);
        }
        excelOperaation.writeExcel(path,result,"ChianCode",title);
        fwr.downloadxls(req, resp, "chaincode.jsp", "ChianCode",path);
    }


    /**
     *  智能合约模型报表下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doDownChainCodeModel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String path=this.getServletContext().getRealPath("test/test.xls");
        ChainCodeModelImpl chainCodeModel = new ChainCodeModelImpl();
        List<ChainCodeModelDomain> chainCodeModelDomains = chainCodeModel.SendChainCodeModelData();
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件的读写对象
        ExcelOperaation excelOperaation = new ExcelOperaation();
        List<String[]> result = new ArrayList<String[]>();
        String[] title={"业务ID","业务流水号","业务流水号","上链时间","模型id","模型类型","模型版本","身份证号","评估模型","Hash值"};
//        String logfile="";
        for (int i = 0; i < chainCodeModelDomains.size(); i++) {

            ChainCodeModelDomain chainCodeModelDomain = chainCodeModelDomains.get(i);
            String[] values = {chainCodeModelDomain.getRecordId(),chainCodeModelDomain.getBusinessNumber(),chainCodeModelDomain.getEstimateModelType(),
                    chainCodeModelDomain.getEstimateDate(),chainCodeModelDomain.getEstimateModelId(),chainCodeModelDomain.getEstimateModelType(),chainCodeModelDomain.getEstimateModelVersion(),
                    chainCodeModelDomain.getHashData(),chainCodeModelDomain.getRemark(),chainCodeModelDomain.getTxId()
            };
//            logfile+= chainCodeModelDomain.getRecordId()+","+chainCodeModelDomain.getBusinessNumber()+","+chainCodeModelDomain.getEstimateModelType()
//                    +","+chainCodeModelDomain.getEstimateDate()+","+chainCodeModelDomain.getEstimateModelId()
//                    +","+chainCodeModelDomain.getEstimateModelType()+","+chainCodeModelDomain.getEstimateModelVersion()+","+chainCodeModelDomain.getHashData()
//                    +","+chainCodeModelDomain.getRemark()+","+chainCodeModelDomain.getTxId()+"\n";
            result.add(values);
        }
        excelOperaation.writeExcel(path,result,"ChainCodeModel",title);
//        fwr.appendMethodB(path,logfile);
        fwr.downloadxls(req, resp, "businesslist.jsp", "ChainCodeModel",path);
    }

    /**
     * 日志报表记录下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doDownLog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        String path=this.getServletContext().getRealPath("test/test.xls");// 文件路径

        WorkBaseImpl workBase = new WorkBaseImpl();// 新建一个方法对象
        List<Log> logs = workBase.SendOperateData(pageIndex, pageSize);// 获取日志数据
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件的读写对象

        ExcelOperaation excelOperaation = new ExcelOperaation();// 读写xls文件的工具
        List<String[]> result = new ArrayList<String[]>();// 取出表格内容
        String[] title={"业务流水号","用户名","操作","业务时间"};
        String logfile="";
        for (int i = 0; i < logs.size(); i++) {
            Log log = logs.get(i);
            String[] values ={log.getId(),log.getLeader(),log.getVerifydate(),log.getServicetype()};
            result.add(values);
//            logfile+=log.getId()+","+log.getLeader()+","+log.getVerifydate()+","+log.getServicetype()+"\n";
        }
        excelOperaation.writeExcel(path,result,"Log",title);
//        fwr.appendMethodB(path,logfile);
        fwr.downloadxls(req, resp, "businesslist.jsp", "Log",path);
    }

    protected void doDownP2PLoan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        String path=this.getServletContext().getRealPath("test/testfile.txt");
        P2PCompanyImpl p2PCompany = new P2PCompanyImpl();
        List<P2PCompany> p2PCompanies = p2PCompany.SendP2PCompanyData();
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//文件的读写对象
        String p2PCompaniesfile="";
        for (int i = 0; i < p2PCompanies.size(); i++) {
            P2PCompany p2PCompanydetail = p2PCompanies.get(i);
            p2PCompaniesfile+=p2PCompanydetail.getId()+","+p2PCompanydetail.getUname()+","+p2PCompanydetail.getTime()
                    +","+p2PCompanydetail.getPlace()+","+p2PCompanydetail.getTerm()+","+p2PCompanydetail.getAverage()
                    +","+p2PCompanydetail.getScore()+","+p2PCompanydetail.getMoney()+","+p2PCompanydetail.getEquity()+"\n";
        }

        fwr.appendMethodB(path,p2PCompaniesfile);
        fwr.download(req, resp, "businesslist.jsp", "P2PLoan",path);
    }
    /**
     * 导入模型下载
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doDownModel(HttpServletRequest req, HttpServletResponse resp,String modelfilename,String modelname) throws ServletException, IOException {
        FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();//读写文件工具类
        String realPath = this.getServletContext().getRealPath(modelfilename);
        String filename=modelname+"file";
        fwr.downloadxls(req, resp, "netloan.jsp", filename,realPath);
    }


//    private void upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf8");
//        // 获取上传文件域
//        Part part = request.getPart("headShot");
//        // 获取上传文件名称
//        String fileName = part.getSubmittedFileName();
//        // 为防止上传文件重名，对文件重新命名
//        String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
//        // 将上传的文件保存在服务器发布路径的application/images路径下
//        // String filePath =
//        // getServletContext().getRealPath("/application/images");
//        String filePath = "D:/application/files";
//        System.out.println(filePath);
//        File f = new File(filePath);
//        if (!f.exists()) {
//            f.mkdirs();
//        }
//        part.write(filePath + "/" + newFileName);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("updown.jsp");
//        dispatcher.forward(request, response);
//
//    }



}
