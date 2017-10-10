import com.after.utils.FtpDataPara;
import com.after.utils.SFTPUtils;
import com.after.utils.SftpManager;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class main {
  public static void main(String args[])
  {
    SFTPUtils sftp = null;
    List<String> filePathList = new ArrayList<String>();
    try
    {
      sftp = new SFTPUtils("172.16.1.30", "htwl", "htwl@123");
      //链接sftp
      sftp.connect();
      //上传
      sftp.uploadFile("/data/",new File("D:\\QRCode.jar").getName(),"D:\\","QRCode.jar");
      // 下载
      //sftp.batchDownLoadFile("/data/", "D:/usr/local/", "QRCode", ".jar", true);
      sftp.downloadFile("/data/","QRCode.jar","D:/usr/local/","QRCod1111e.jar");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (sftp!=null){
        sftp.disconnect();
      }
    }

    /*SftpManager sfm	= new SftpManager("172.16.1.30", "htwl", "htwl@123",22);

    ChannelSftp chSftp = null;
    try {
      chSftp = sfm.getChannel();
     log.info("---------> KaServer getChannel() connect time :: " );
    List<String> listFile=new ArrayList<>();
      listFile.add("D:\\QRCode.jar");
      while (!listFile.isEmpty())
      {
        String strFile = listFile.get(0);
        String[] astrFile = strFile.split("/");
        String strFileName = astrFile[astrFile.length - 1];
        listFile.remove(0);
        String strResult = sfm.uploadFile(chSftp,strFile, FtpDataPara.strFtpServerPath + strFileName);
        log.info("Send to DataServer : " + strFile + " result:" + strResult);
        if ("success".equals(strResult))
        {
          int nCount = 0;
          Boolean bFtpSuccess = false;
          while (!bFtpSuccess)
          {
            nCount++;
            if (nCount >= 3)
            {
             *//* PubFunc.execSysCmd("mv " + strFile + " " + PubFunc.getSonDir(PubString.strErrorDataPath));*//*
              log.info(strFile + "文件通过ftp传送失败"+" --------->>>>>>          mv ");
              break;
            }
            if ("success".equals(sfm.rename(chSftp,FtpDataPara.strFtpServerPath+"temp/" + strFileName, FtpDataPara.strFtpServerPath + strFileName)))
            {
              bFtpSuccess = true;
              // 发送完成后备份文件
             // PubFunc.execSysCmd("mv " + strFile + " " + PubFunc.getSonDir(PubString.strBackDataPath));
              log.info(strFile + "文件通过ftp传送完成");
              break;
            }
          }
        }
      }
    } catch (JSchException e) {
      log.error("异常：",e);
    }finally{
      try {
        sfm.closeChannel(chSftp);
      } catch (Exception e) {
        log.error("异常：",e);
      }
    }*/

  }
}
