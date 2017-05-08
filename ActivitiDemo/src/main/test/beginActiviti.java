import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * Created by wangbiao on 2017/5/7.
 *
 * 初始创建工作需要的23张表
 */
public class beginActiviti {
    /**
     * 生成25张Activiti表
     */
    @Test
    public void testCreateTable() {
        // 引擎配置
        ProcessEngineConfiguration pec=ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEncoding=utf8");
        //pec.setJdbcUrl("jdbc:mysql://localhost:3306/activiti");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("123456");

        /**
         * DB_SCHEMA_UPDATE_FALSE 不能自动创建表，需要表存在
         * create-drop 先删除表再创建表
         * DB_SCHEMA_UPDATE_TRUE 如何表不存在，自动创建和更新表
         */
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 获取流程引擎对象
        ProcessEngine processEngine=pec.buildProcessEngine();
    }

    /**
     * 使用xml配置 简化
     */
    @Test
    public void testCreateTableWithXml(){
        // 引擎配置
        ProcessEngineConfiguration pec=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 获取流程引擎对象
        ProcessEngine processEngine=pec.buildProcessEngine();
    }
}
