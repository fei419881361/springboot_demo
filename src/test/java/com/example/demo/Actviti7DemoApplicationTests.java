package com.example.demo;

import com.example.demo.config.SecurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhanglf
 * @Date 2020/11/4 9:57 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Actviti7DemoApplicationTests {
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private SecurityUtil securityUtil;


    @Test
    public void contextLoads(){
        securityUtil.logInAs("system");
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println(" 可 用 的 流 程 定 义 数 量 ： " + processDefinitionPage.getTotalItems());
        for (org.activiti.api.process.model.ProcessDefinition pd :
                processDefinitionPage.getContent()) {
            System.out.println("流程定义：" + pd);
        }
    }
}
