package test.com.bby.ants;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.primefaces.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bby.ants.entity.Adduserlog;
import com.bby.ants.entity.Alarminfo;
import com.bby.ants.entity.Gateway;
import com.bby.ants.entity.Monitorpoints;
import com.bby.ants.entity.l_log;
import com.bby.ants.service.AlarmService;
import com.bby.ants.service.GateService;
import com.bby.ants.service.L_LogService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:wl-applicationContext.xml")
public class TestService {
    private static volatile boolean initialized = false;
     
    public TestService() {
        //initEnvironment();
    }

    private static void initEnvironment() {
        if (!initialized) {
            synchronized (TestService.class) {
                if (!initialized) {
                    initialized = true;
                }
            }
        }
    }
  //===================================告警管理=====================================
    /**
     * 插入节点
     */
    @Test
    public void testAlarminfoInsertNode(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	AlarmService g = (AlarmService) ac.getBean("alarmService");
    	
    	Alarminfo record = new Alarminfo();
    	record.setAlarmtime(new Date());
    	record.setAlarmtype("告警类型");
    	record.setId((long) 1111);
    	record.setMonitorpointsname("监视节点名称");
    	record.setRemark("标记");
    	record.setResult("结果");
    	record.setSendercomp("发射机部件");
    	record.setTemperature(30);
    	record.setThreshold(2);
    	
    	g.insertAlarmNode(record);
    	
    }
    
    /**
     * 更新节点
     */
    @Test
    public void testAlarminfoUpdateNode(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	AlarmService g = (AlarmService) ac.getBean("alarmService");
    	
    	Alarminfo record = new Alarminfo();
    	record.setAlarmtime(new Date());
    	record.setAlarmtype("告警类型1111");
    	record.setId((long) 1111);
    	record.setMonitorpointsname("监视节点名称");
    	record.setRemark("标记");
    	record.setResult("结果");
    	record.setSendercomp("发射机部件");
    	record.setTemperature(30);
    	record.setThreshold(2);
    	
    	g.updateAlarmNode(record);
    }
    
    /**
     * 删除节点
     */
    @Test
    public void testAlarminfodeleteNode(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	AlarmService g = (AlarmService) ac.getBean("alarmService");
    	
    	g.deleteAlarmNode(1111);
    	
    }
  //===================================告警管理=====================================
  //===================================配置=====================================
    /**
     * 插入设备
     */
    @Test
    public void testGateServiceInsert(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	GateService g = (GateService) ac.getBean("gatewayService");
    	//GateService g = new GateService();
		Gateway record = new Gateway();
		record.setBuzzer(1);
		record.setChannel(1);
		record.setHostid(1);
		record.setIp("x.x.x.x");
		record.setName("one");
		record.setNetworkid(1);
		record.setNodesnum(1);
		record.setPort(1);
		System.out.println(g.insertDevice(record));
		
		
		record = new Gateway();
		record.setBuzzer(1);
		record.setChannel(1);
		record.setHostid(1);
		record.setIp("x.x.x.x");
		record.setName("one");
		record.setNetworkid(1);
		record.setNodesnum(1);
		record.setPort(1);
		System.out.println(g.insertDevice(record));
    }
    
    /**
     * 更新设备
     */
    @Test
    public void testGateServiceUpdate(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	GateService g = (GateService) ac.getBean("gatewayService");
    	//GateService g = new GateService();
		Gateway record = new Gateway();
		record.setId(1);
		record.setBuzzer(2);
		record.setChannel(2);
		record.setHostid(2);
		record.setIp("x.x.x.x");
		record.setName("one");
		record.setNetworkid(2);
		record.setNodesnum(2);
		record.setPort(2);
		
		System.out.println(g.updateDevice(record));
    }
    
    /**
     * 删除设备
     */
    @Test
    public void testGatewayServiceDelete(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	GateService g = (GateService) ac.getBean("gatewayService");
    	
    	g.deleteDevice(1);
    }
    
    
    /**
     * 插入节点
     */
    @Test
    public void testGateServiceMonitorPointInsert(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	GateService g = (GateService) ac.getBean("gatewayService");
    	//GateService g = new GateService();
		Monitorpoints record = new Monitorpoints();
		record.setAddress("地址");
		record.setBeyondBounds((float)1.111);
		record.setChannel(11);
		record.setCompid((long) 2222);
		record.setEarlyWarning((float) 2.222);
		record.setEmergency((float) 3.333);
		record.setGatewayid((long) 44444);
		record.setId((long) 12121);
		record.setName("节点名称");
		record.setRemark("标记");
		record.setSendername("发射机名称");
		
		g.insertMonitorPoint(record);
    }
    
    /**
     * 更新节点
     */
    @Test
    public void testGateServiceMonitorPointUpdate(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	GateService g = (GateService) ac.getBean("gatewayService");
    	//GateService g = new GateService();
    	Monitorpoints record = new Monitorpoints();
		record.setAddress("地址111");
		record.setBeyondBounds((float)1.111);
		record.setChannel(11);
		record.setCompid((long) 2222);
		record.setEarlyWarning((float) 2.222);
		record.setEmergency((float) 3.333);
		record.setGatewayid((long) 44444);
		record.setId((long) 12121);
		record.setName("节点名称");
		record.setRemark("标记");
		record.setSendername("发射机名称");
		
		System.out.println(g.updateMonitorPoint(record));
    }
    
    /**
     * 删除节点
     */
    @Test
    public void testGatewayServiceMonitorPointDelete(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	GateService g = (GateService) ac.getBean("gatewayService");
    	
    	g.deleteMonitorPoint(12121);
    }
    //===================================配置=====================================
    
    //=================================系统日志=====================================
    
    /**
     * 插入日志
     */
    @Test
    public void testL_logServiceInsert(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	L_LogService s = (L_LogService) ac.getBean("l_logService");
    	
    	l_log record = new l_log();
    	record.setJobnum("one");
    	record.setLogId((long) 1111);
    	record.setMobile("13888888888");
    	record.setOperate("查询历史事件");
    	record.setOperateDate(new Date());
    	record.setUserId((long) 222222);
    	
    	s.insertLog(record);
    }
    
    /**
     * 删除日志
     */
    @Test
    public void testL_logServiceDelete(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	L_LogService s = (L_LogService) ac.getBean("l_logService");
    	
    	l_log record = new l_log();
    	record.setJobnum("one");
    	record.setLogId((long) 1111);
    	record.setMobile("13888888888");
    	record.setOperate("查询历史事件");
    	record.setOperateDate(new Date());
    	record.setUserId((long) 222222);
    	
    	s.deleteLog(1111);
    }
    
    /**
     * 更新日志
     */
    @Test
    public void testL_logServiceUpdate(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	L_LogService s = (L_LogService) ac.getBean("l_logService");
    	
    	l_log record = new l_log();
    	record.setJobnum("one");
    	record.setLogId((long) 1111);
    	record.setMobile("13888888888");
    	record.setOperate("更新查询历史事件");
    	record.setOperateDate(new Date());
    	record.setUserId((long) 222222);
    	
    	s.updateLog(record);
    }
    
    /**
     * 插入用户日志
     */
    @Test
    public void testL_logServiceAddUserInsert(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	L_LogService s = (L_LogService) ac.getBean("l_logService");
    	
    	Adduserlog record = new Adduserlog();
    	record.setAddDate(new Date());
    	record.setAddUser("测试人员");
    	record.setId(101010);
    	record.setModifyDate(new Date());
    	record.setModifyUser("修改人员");
    	record.setUserId((long) 12121321);
    	record.setUserName("用户姓名");
    	
    	s.addUserlogInsert(record);
    }
    
    /**
     * 删除用户日志
     */
    @Test
    public void testL_logServiceAddUserDelete(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	L_LogService s = (L_LogService) ac.getBean("l_logService");
    	
    	s.deleteUserlog(101010);
    }
    
    /**
     * 更新用户日志
     */
    @Test
    public void testL_logServiceAddUserUpdate(){
    	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("wl-applicationContext.xml");
    	L_LogService s = (L_LogService) ac.getBean("l_logService");
    	
    	Adduserlog record = new Adduserlog();
    	record.setAddDate(new Date());
    	record.setAddUser("修改测试人员");
    	record.setId(101010);
    	record.setModifyDate(new Date());
    	record.setModifyUser("修改人员");
    	record.setUserId((long) 12121321);
    	record.setUserName("用户姓名");
    	
    	s.updateUserlog(record);
    }
    //=================================系统日志=====================================
    
    //=================================系统日志=====================================
    //=================================系统日志=====================================
}
