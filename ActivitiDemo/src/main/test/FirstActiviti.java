import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * Created by pc5 on 2017/5/5.
 */
public class FirstActiviti
{

    /**
     * 部署流程定义
     */
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**部署流程定义*/
    @Test
    public void deploymentProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                .createDeployment()//创建一个部署对象
                .name("helloworld入门程序")//添加部署的名称
                .addClasspathResource("bmpb/helloworld.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                //	.addClasspathResource("diagrams/helloworld.png")//从classpath的资源中加载，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());//1
        System.out.println("部署名称："+deployment.getName());//helloworld入门程序
    }
    /**
     * 启动流程实例
     */
    @Test
    public void startProcessInstance() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String processDefinitionKey = "helloworld";
        ProcessInstance pi = processEngine.getRuntimeService()
                .startProcessInstanceByKey(processDefinitionKey);

        System.out.println("流程实例ID：" + pi.getId());
        System.out.println("流程定义ID：" + pi.getProcessDefinitionId());
    }

    /**
     * 查询当前人的个人认为
     */
    @Test
    public void findMyPersonTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String assignee = "张三";
        List<Task> list = processEngine.getTaskService().createTaskQuery()
                .taskAssignee(assignee).list();
        for (Task task : list) {
            System.out.println(task.getId());
            System.out.println(task.getName());
            System.out.println(task.getCreateTime());
            System.out.println(task.getAssignee());
        }
    }

    /**
     * 完成我的任务
     */
    @Test
    public void completeMyPersonTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String taskId = "104";
        processEngine.getTaskService().complete(taskId);

        System.out.println("完成任务：" + taskId);
    }
}
