package org.productivity.java.syslog4j.test.misc;

import java.net.InetAddress;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import junit.framework.TestCase;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogBackLogHandlerIF;
import org.productivity.java.syslog4j.SyslogConfigIF;
import org.productivity.java.syslog4j.SyslogConstants;
import org.productivity.java.syslog4j.SyslogIF;
import org.productivity.java.syslog4j.SyslogMessageIF;
import org.productivity.java.syslog4j.SyslogMessageModifierIF;
import org.productivity.java.syslog4j.SyslogMessageProcessorIF;
import org.productivity.java.syslog4j.SyslogRuntimeException;
import org.productivity.java.syslog4j.impl.AbstractSyslog;
import org.productivity.java.syslog4j.impl.AbstractSyslogConfig;
import org.productivity.java.syslog4j.impl.AbstractSyslogConfigIF;
import org.productivity.java.syslog4j.impl.backlog.Syslog4jBackLogHandler;
import org.productivity.java.syslog4j.impl.backlog.printstream.SystemErrSyslogBackLogHandler;
import org.productivity.java.syslog4j.impl.message.modifier.hash.HashSyslogMessageModifierConfig;
import org.productivity.java.syslog4j.impl.message.modifier.mac.MacSyslogMessageModifier;
import org.productivity.java.syslog4j.impl.message.modifier.mac.MacSyslogMessageModifierConfig;
import org.productivity.java.syslog4j.impl.message.modifier.sequential.SequentialSyslogMessageModifierConfig;
import org.productivity.java.syslog4j.impl.message.modifier.text.StringCaseSyslogMessageModifier;
import org.productivity.java.syslog4j.impl.message.processor.structured.StructuredSyslogMessageProcessor;
import org.productivity.java.syslog4j.impl.message.structured.StructuredSyslogMessage;
import org.productivity.java.syslog4j.impl.multiple.MultipleSyslog;
import org.productivity.java.syslog4j.impl.multiple.MultipleSyslogConfig;
import org.productivity.java.syslog4j.impl.net.AbstractNetSyslogConfig;
import org.productivity.java.syslog4j.impl.net.tcp.TCPNetSyslog;
import org.productivity.java.syslog4j.impl.net.tcp.TCPNetSyslogConfig;
import org.productivity.java.syslog4j.impl.net.tcp.TCPNetSyslogWriter;
import org.productivity.java.syslog4j.impl.net.tcp.pool.PooledTCPNetSyslog;
import org.productivity.java.syslog4j.impl.net.tcp.pool.PooledTCPNetSyslogConfig;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslog;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogConfig;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogWriter;
import org.productivity.java.syslog4j.impl.net.tcp.ssl.pool.PooledSSLTCPNetSyslogConfig;
import org.productivity.java.syslog4j.impl.net.udp.UDPNetSyslog;
import org.productivity.java.syslog4j.impl.net.udp.UDPNetSyslogConfig;
import org.productivity.java.syslog4j.impl.unix.socket.UnixSocketSyslog;
import org.productivity.java.syslog4j.impl.unix.socket.UnixSocketSyslogConfig;
import org.productivity.java.syslog4j.server.SyslogServer;
import org.productivity.java.syslog4j.server.SyslogServerConfigIF;
import org.productivity.java.syslog4j.server.SyslogServerEventHandlerIF;
import org.productivity.java.syslog4j.server.SyslogServerSessionEventHandlerIF;
import org.productivity.java.syslog4j.server.impl.event.printstream.SystemErrSyslogServerEventHandler;
import org.productivity.java.syslog4j.server.impl.event.structured.StructuredSyslogServerEvent;
import org.productivity.java.syslog4j.server.impl.net.tcp.TCPNetSyslogServerConfig;
import org.productivity.java.syslog4j.server.impl.net.tcp.TCPNetSyslogServerConfigIF;
import org.productivity.java.syslog4j.server.impl.net.udp.UDPNetSyslogServerConfig;

public class SyslogParameterTest extends TestCase {
	public static class FakeSyslogConfig implements SyslogConfigIF {
		private static final long serialVersionUID = -4215212236417198317L;

		public void addMessageModifier(SyslogMessageModifierIF messageModifier) {
			//
		}
		
		public String getIdent() {
			return null;
		}
		
		public void setIdent(String ident) {
			//
		}

		public String getLocalName() {
			return null;
		}
		
		public void setLocalName(String localName) {
			//
		}
		
		public String getCharSet() {
			return null;
		}

		public int getFacility() {
			return 0;
		}

		public String getHost() {
			return null;
		}

		public int getPort() {
			return 0;
		}
		
		public boolean isTruncateMessage() {
			return false;
		}

		public Class getSyslogClass() {
			return java.lang.String.class;
		}

		public void insertMessageModifier(int index, SyslogMessageModifierIF messageModifier) {
			//
		}

		public boolean isCacheHostAddress() {
			return false;
		}

		public boolean isSendLocalName() {
			return false;
		}

		public boolean isSendLocalTimestamp() {
			return false;
		}

		public boolean isThrowExceptionOnInitialize() {
			return false;
		}

		public boolean isThrowExceptionOnWrite() {
			return false;
		}

		public void removeAllMessageModifiers() {
			//
		}

		public void removeMessageModifier( SyslogMessageModifierIF messageModifier) {
			//
		}

		public void setCacheHostAddress(boolean cacheHostAddress) {
			//
		}

		public void setCharSet(String charSet) {
			//
		}

		public void setFacility(int facility) {
			//
		}

		public void setFacility(String facilityName) {
			//
		}

		public void setHost(String host) throws SyslogRuntimeException {
			//
		}

		public void setPort(int port) throws SyslogRuntimeException {
			//
		}

		public void setSendLocalName(boolean sendLocalName) {
			//
		}

		public void setSendLocalTimestamp(boolean sendLocalTimestamp) {
			//
		}

		public void setThrowExceptionOnInitialize(boolean throwExceptionOnInitialize) {
			//
		}

		public void setThrowExceptionOnWrite(boolean throwExceptionOnWrite) {
			//
		}

		public boolean isIncludeIdentInMessageModifier() {
			return false;
		}

		public void setIncludeIdentInMessageModifier(boolean throwExceptionOnInitialize) {
			//
		}

		public void addBackLogHandler(SyslogBackLogHandlerIF backLogHandler) {
			//
		}

		public void insertBackLogHandler(int index, SyslogBackLogHandlerIF backLogHandler) {
			//
		}

		public void removeAllBackLogHandlers() {
			//
		}

		public void removeBackLogHandler(SyslogBackLogHandlerIF backLogHandler) {
			//
		}

		public int getMaxShutdownWait() {
			return 0;
		}

		public int getWriteRetries() {
			return 0;
		}

		public void setMaxShutdownWait(int maxShutdownWait) {
			//
		}

		public void setWriteRetries(int writeRetries) {
			//
		}

		public int getMaxMessageLength() {
			return 0;
		}

		public void setMaxMessageLength(int maxMessageLength) {
			//
		}
		
		public void setTruncateMessage(boolean truncateMessage) {
			//
		}

		public boolean isUseStructuredData() {
			return false;
		}

		public void setUseStructuredData(boolean useStructuredData) {
			//
		}
	}

	public static class FakeSyslogServerConfig implements SyslogServerConfigIF {
		private static final long serialVersionUID = 4565257970196293922L;

		public void addEventHandler(SyslogServerEventHandlerIF eventHandler) {
			//
		}

		public List getEventHandlers() {
			return null;
		}

		public String getHost() {
			return null;
		}

		public int getPort() {
			return 0;
		}

		public long getShutdownWait() {
			return 0;
		}

		public Class getSyslogServerClass() {
			return Object.class;
		}

		public void insertEventHandler(int pos, SyslogServerEventHandlerIF eventHandler) {
			//
		}

		public void removeAllEventHandlers() {
			//
		}

		public void removeEventHandler(SyslogServerEventHandlerIF eventHandler) {
			//
		}

		public void setHost(String host) throws SyslogRuntimeException {
			//
		}

		public void setPort(int port) throws SyslogRuntimeException {
			//
		}

		public void setShutdownWait(long shutdownWait) {
			//
		}

		public String getCharSet() {
			return null;
		}

		public void setCharSet(String charSet) {
			//			
		}

		public boolean isUseStructuredData() {
			return false;
		}

		public void setUseStructuredData(boolean useStructuredData) {
			//
		}

		public int getThreadPriority() {
			return 0;
		}

		public boolean isUseDaemonThread() {
			return false;
		}

		public void setThreadPriority(int threadPriority) {
			//
		}

		public void setUseDaemonThread(boolean useDaemonThread) {
			//
		}

		public Object getDateTimeFormatter() {
			return null;
		}

		public void setDateTimeFormatter(Object dateTimeFormatter) {
			//
		}
	}
	
	public void testSyslogExists() {
		assertFalse(Syslog.exists(null));
		assertFalse(Syslog.exists(""));
		assertTrue(Syslog.exists("udp"));
		assertEquals("udp",Syslog.getInstance("udp").getProtocol());
	}
	
	public void testSyslogServerExists() {
		SyslogServer.createDefaultServer();
		assertFalse(SyslogServer.exists(null));
		assertFalse(SyslogServer.exists(""));
		assertTrue(SyslogServer.exists("udp"));
		assertEquals("udp",SyslogServer.getInstance("udp").getProtocol());
	}
	
	public void testSyslogCreateInstance() {
		try {
			Syslog.createInstance(null,null);
			fail("Syslog should not accept null parameters");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}

		try {
			Syslog.createInstance("udp",null);
			fail("Syslog should not accept a null config parameter");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}

		SyslogConfigIF config = new UDPNetSyslogConfig();
		
		try {
			Syslog.createInstance("udp",config);
			fail("Syslog should not be able to override an already existing protocol");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}
		
		try {
			config = new FakeSyslogConfig();
			Syslog.createInstance("fake",config);
			fail("Syslog should not be able to construct a non-SyslogIF class");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}
	}

	public void testSyslogServerCreateInstance() {
		try {
			SyslogServer.createInstance(null,null);
			fail("SyslogServer should not accept null parameters");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}

		try {
			SyslogServer.createInstance("udp",null);
			fail("Syslog should not accept a null config parameter");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}

		SyslogServerConfigIF config = new UDPNetSyslogServerConfig();
		
		try {
			if (!SyslogServer.exists("udp")) {
				SyslogServer.createThreadedInstance("udp", new UDPNetSyslogServerConfig());
			}
			SyslogServer.createInstance("udp", config);
			fail("SyslogServer should not be able to override an already existing protocol");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}
		
		try {
			config = new FakeSyslogServerConfig();
			SyslogServer.createInstance("fake",config);
			fail("SyslogServer should not be able to construct a non-SyslogIF class");
			
		} catch (SyslogRuntimeException sre) {
			assertTrue(true);
		}
	}

	public void testMessageModifier(AbstractSyslogConfigIF syslogConfig) {
		syslogConfig.removeAllMessageModifiers();
		
		syslogConfig.addMessageModifier(null);
		
		syslogConfig.insertMessageModifier(0,null);
		
		try {
			syslogConfig.insertMessageModifier(888, StringCaseSyslogMessageModifier.LOWER);
			fail("should generate IndexOutOfBoundsException");
			
		} catch (SyslogRuntimeException sre) {
			//
		}

		syslogConfig.removeMessageModifier(null);
	}
	
	protected void testBackLogHandler(AbstractSyslogConfigIF syslogConfig) {
		SystemErrSyslogBackLogHandler handler = new SystemErrSyslogBackLogHandler();
		
		syslogConfig.removeAllBackLogHandlers();
		
		syslogConfig.addBackLogHandler(null);
		
		syslogConfig.addBackLogHandler(handler);
		assertEquals(1,syslogConfig.getBackLogHandlers().size());
		assertEquals(syslogConfig.getBackLogHandlers().get(0),handler);
		
		syslogConfig.removeBackLogHandler(handler);
		assertEquals(1,syslogConfig.getBackLogHandlers().size());

		syslogConfig.insertBackLogHandler(0,null);

		syslogConfig.insertBackLogHandler(0,handler);
		assertEquals(1,syslogConfig.getBackLogHandlers().size());
		
		syslogConfig.removeAllBackLogHandlers();
		assertEquals(1,syslogConfig.getBackLogHandlers().size());
		
		ArrayList list = new ArrayList();
		list.add(handler);
		
		((AbstractSyslogConfig) syslogConfig).setBackLogHandlers(list);
		assertEquals(1,syslogConfig.getBackLogHandlers().size());
		
		try {
			syslogConfig.insertBackLogHandler(999,handler);
			fail("should generate IndexOutOfBoundsException");
			
		} catch (SyslogRuntimeException sre) {
			//
		}
		
		syslogConfig.removeBackLogHandler(null);
	}

	public void testTcpNetSyslogConfigCreate() {
		AbstractNetSyslogConfig config = null;
		
		config = new TCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH);
		
		testBackLogHandler(config);
		testMessageModifier(config);
		
		assertTrue(config.getSyslogClass() == TCPNetSyslog.class);
		assertEquals(SyslogConstants.FACILITY_AUTH,config.getFacility());

		config = new TCPNetSyslogConfig("hostname0");
		assertEquals("hostname0",config.getHost());
		config.setHost("hostname1");
		assertEquals("hostname1",config.getHost());

		config = new TCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname2");
		assertEquals("hostname2",config.getHost());

		config = new TCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname3",2222);
		assertEquals("hostname3",config.getHost());
		assertEquals(2222,config.getPort());
		config.setPort(3333);
		assertEquals(3333,config.getPort());

		config = new TCPNetSyslogConfig("hostname4",4444);
		assertEquals("hostname4",config.getHost());
		assertEquals(4444,config.getPort());
		
		TCPNetSyslogConfig tcpConfig = new TCPNetSyslogConfig();

		assertEquals(tcpConfig.getDelimiterSequence().length,System.getProperty("line.separator").getBytes().length);
		tcpConfig.setDelimiterSequence("ab".getBytes());
		assertEquals(new String(tcpConfig.getDelimiterSequence()),"ab");
		tcpConfig.setDelimiterSequence("cd");
		assertEquals(new String(tcpConfig.getDelimiterSequence()),"cd");

		assertTrue(tcpConfig.isKeepAlive());
		tcpConfig.setKeepAlive(false);
		assertFalse(tcpConfig.isKeepAlive());

		assertTrue(tcpConfig.isSoLinger());
		tcpConfig.setSoLinger(false);
		assertFalse(tcpConfig.isSoLinger());

		assertTrue(tcpConfig.isReuseAddress());
		tcpConfig.setReuseAddress(false);
		assertFalse(tcpConfig.isReuseAddress());

		assertTrue(tcpConfig.isSetBufferSize());
		tcpConfig.setSetBufferSize(false);
		assertFalse(tcpConfig.isSetBufferSize());
		
		assertEquals(SyslogConstants.TCP_SO_LINGER_SECONDS_DEFAULT,tcpConfig.getSoLingerSeconds());
		tcpConfig.setSoLingerSeconds(99);
		assertEquals(99,tcpConfig.getSoLingerSeconds());
		
		assertTrue(tcpConfig.isThreaded());
		tcpConfig.setThreaded(false);
		assertFalse(tcpConfig.isThreaded());
		
		assertEquals(SyslogConstants.USE_DAEMON_THREAD_DEFAULT,tcpConfig.isUseDaemonThread());
		tcpConfig.setUseDaemonThread(false);
		assertEquals(false,tcpConfig.isUseDaemonThread());
		
		assertEquals(SyslogConstants.THREAD_PRIORITY_DEFAULT,tcpConfig.getThreadPriority());
		tcpConfig.setThreadPriority(3);
		assertEquals(3,tcpConfig.getThreadPriority());

		assertEquals(SyslogConstants.TCP_FRESH_CONNECTION_INTERVAL_DEFAULT,tcpConfig.getFreshConnectionInterval());
		tcpConfig.setFreshConnectionInterval(9779);
		assertEquals(9779,tcpConfig.getFreshConnectionInterval());
	}

	public void testUdpNetSyslogConfigCreate() {
		AbstractNetSyslogConfig config = null;
		
		config = new UDPNetSyslogConfig(SyslogConstants.FACILITY_AUTH);
		
		assertTrue(config.getSyslogClass() == UDPNetSyslog.class);
		assertEquals(SyslogConstants.FACILITY_AUTH,config.getFacility());

		assertNull(config.getSyslogWriterClass());
		
		assertEquals(SyslogConstants.MAX_MESSAGE_LENGTH_DEFAULT,config.getMaxMessageLength());
		config.setMaxMessageLength(99);
		assertEquals(99,config.getMaxMessageLength());
		
		assertEquals(SyslogConstants.FACILITY_AUTH,config.getFacility());
		config.setFacility(SyslogConstants.FACILITY_LOCAL1);
		assertEquals(SyslogConstants.FACILITY_LOCAL1,config.getFacility());
		config.setFacility("LOCAL2");
		assertEquals(SyslogConstants.FACILITY_LOCAL2,config.getFacility());
		
		assertEquals(SyslogConstants.CHAR_SET_DEFAULT,config.getCharSet());
		config.setCharSet("UTF-FAKE");
		assertEquals("UTF-FAKE",config.getCharSet());

		assertEquals(SyslogConstants.MAX_SHUTDOWN_WAIT_DEFAULT,config.getMaxShutdownWait());
		config.setMaxShutdownWait(9999);
		assertEquals(9999,config.getMaxShutdownWait());
		
		assertEquals(SyslogConstants.INCLUDE_IDENT_IN_MESSAGE_MODIFIER_DEFAULT,config.isIncludeIdentInMessageModifier());
		config.setIncludeIdentInMessageModifier(!SyslogConstants.INCLUDE_IDENT_IN_MESSAGE_MODIFIER_DEFAULT);
		assertEquals(!SyslogConstants.INCLUDE_IDENT_IN_MESSAGE_MODIFIER_DEFAULT,config.isIncludeIdentInMessageModifier());

		assertEquals(SyslogConstants.SEND_LOCAL_NAME_DEFAULT,config.isSendLocalName());
		config.setSendLocalName(!SyslogConstants.SEND_LOCAL_NAME_DEFAULT);
		assertEquals(!SyslogConstants.SEND_LOCAL_NAME_DEFAULT,config.isSendLocalName());

		assertEquals(SyslogConstants.SEND_LOCAL_TIMESTAMP_DEFAULT,config.isSendLocalTimestamp());
		config.setSendLocalTimestamp(!SyslogConstants.SEND_LOCAL_TIMESTAMP_DEFAULT);
		assertEquals(!SyslogConstants.SEND_LOCAL_TIMESTAMP_DEFAULT,config.isSendLocalTimestamp());

		assertEquals(SyslogConstants.THREAD_LOOP_INTERVAL_DEFAULT,config.getThreadLoopInterval());
		config.setThreadLoopInterval(8888);
		assertEquals(8888,config.getThreadLoopInterval());

		assertEquals(SyslogConstants.WRITE_RETRIES_DEFAULT,config.getWriteRetries());
		config.setWriteRetries(7777);
		assertEquals(7777,config.getWriteRetries());

		testBackLogHandler(config);
		
		assertEquals(new String(SyslogConstants.SPLIT_MESSAGE_BEGIN_TEXT_DEFAULT),new String(config.getSplitMessageBeginText()));
		
		config.setSplitMessageBeginText("abc");
		assertEquals("abc",new String(config.getSplitMessageBeginText()));
		config.setSplitMessageBeginText("def".getBytes());
		assertEquals("def",new String(config.getSplitMessageBeginText()));

		assertEquals(new String(SyslogConstants.SPLIT_MESSAGE_END_TEXT_DEFAULT),new String(config.getSplitMessageEndText()));
		
		config.setSplitMessageEndText("ghi");
		assertEquals("ghi",new String(config.getSplitMessageEndText()));
		
		config.setSplitMessageEndText("jkl".getBytes());
		assertEquals("jkl",new String(config.getSplitMessageEndText()));

		config = new UDPNetSyslogConfig("hostname0");
		assertEquals("hostname0",config.getHost());
		config.setHost("hostname1");
		assertEquals("hostname1",config.getHost());

		config = new UDPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname2");
		assertEquals("hostname2",config.getHost());

		config = new UDPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname3",2222);
		assertEquals("hostname3",config.getHost());
		assertEquals(2222,config.getPort());
		config.setPort(3333);
		assertEquals(3333,config.getPort());

		config = new UDPNetSyslogConfig("hostname4",4444);
		assertEquals("hostname4",config.getHost());
		assertEquals(4444,config.getPort());
		
		assertEquals(3,config.getSplitMessageBeginText().length);
		for(int i=0; i<3; i++) {
			assertEquals((byte)'.',config.getSplitMessageBeginText()[i]);
		}
		assertEquals(3,config.getSplitMessageEndText().length);
		for(int i=0; i<3; i++) {
			assertEquals((byte)'.',config.getSplitMessageEndText()[i]);
		}
	}

	public void testTcpNetSyslogServerConfigCreate() {
		TCPNetSyslogServerConfig tcpServerConfig = new TCPNetSyslogServerConfig(9999);
		assertEquals(9999,tcpServerConfig.getPort());
		tcpServerConfig.setPort(8888);
		assertEquals(8888,tcpServerConfig.getPort());

		tcpServerConfig = new TCPNetSyslogServerConfig("hostname1",7777);
		assertEquals("hostname1",tcpServerConfig.getHost());
		tcpServerConfig.setHost("hostname2");
		assertEquals("hostname2",tcpServerConfig.getHost());
		assertEquals(7777,tcpServerConfig.getPort());

		tcpServerConfig = new TCPNetSyslogServerConfig("hostname3",6666,99);
		assertEquals(6666,tcpServerConfig.getPort());
		assertEquals(99,tcpServerConfig.getBacklog());
		tcpServerConfig.setBacklog(88);
		assertEquals(88,tcpServerConfig.getBacklog());
		assertEquals(SyslogConstants.TCP_MAX_ACTIVE_SOCKETS_DEFAULT,tcpServerConfig.getMaxActiveSockets());
		tcpServerConfig.setMaxActiveSockets(111);
		assertEquals(111,tcpServerConfig.getMaxActiveSockets());
		assertEquals(SyslogConstants.TCP_MAX_ACTIVE_SOCKETS_BEHAVIOR_DEFAULT,tcpServerConfig.getMaxActiveSocketsBehavior());
		tcpServerConfig.setMaxActiveSocketsBehavior(TCPNetSyslogServerConfigIF.MAX_ACTIVE_SOCKETS_BEHAVIOR_REJECT);
		assertEquals(TCPNetSyslogServerConfigIF.MAX_ACTIVE_SOCKETS_BEHAVIOR_REJECT,tcpServerConfig.getMaxActiveSocketsBehavior());
		
		tcpServerConfig = new TCPNetSyslogServerConfig(5555,77);
		assertEquals(5555,tcpServerConfig.getPort());
		assertEquals(77,tcpServerConfig.getBacklog());
		tcpServerConfig.setBacklog(66);
		assertEquals(66,tcpServerConfig.getBacklog());

		tcpServerConfig = new TCPNetSyslogServerConfig("hostname4");
		assertEquals("hostname4",tcpServerConfig.getHost());
		
		SyslogServerSessionEventHandlerIF handler = new SystemErrSyslogServerEventHandler();
		assertEquals(0,tcpServerConfig.getEventHandlers().size());
		tcpServerConfig.addEventHandler(handler);
		assertEquals(1,tcpServerConfig.getEventHandlers().size());
		SyslogServerSessionEventHandlerIF handler2 = SystemErrSyslogServerEventHandler.create();
		tcpServerConfig.insertEventHandler(0,handler2);
		assertEquals(2,tcpServerConfig.getEventHandlers().size());
		tcpServerConfig.removeEventHandler(handler);
		assertEquals(1,tcpServerConfig.getEventHandlers().size());
		assertTrue(handler2 == tcpServerConfig.getEventHandlers().get(0));
		tcpServerConfig.removeAllEventHandlers();
		assertEquals(0,tcpServerConfig.getEventHandlers().size());
		assertEquals(SyslogConstants.CHAR_SET_DEFAULT,tcpServerConfig.getCharSet());
		tcpServerConfig.setCharSet("zzyyxx");
		assertEquals("zzyyxx",tcpServerConfig.getCharSet());

		assertEquals(SyslogConstants.USE_DAEMON_THREAD_DEFAULT,tcpServerConfig.isUseDaemonThread());
		tcpServerConfig.setUseDaemonThread(false);
		assertEquals(false,tcpServerConfig.isUseDaemonThread());
		
		assertEquals(SyslogConstants.THREAD_PRIORITY_DEFAULT,tcpServerConfig.getThreadPriority());
		tcpServerConfig.setThreadPriority(2);
		assertEquals(2,tcpServerConfig.getThreadPriority());
	}

	public void testUdpNetSyslogServerConfigCreate() {
		UDPNetSyslogServerConfig udpServerConfig = new UDPNetSyslogServerConfig(9999);
		assertEquals(9999,udpServerConfig.getPort());
		udpServerConfig.setPort(8888);
		assertEquals(8888,udpServerConfig.getPort());
		
		udpServerConfig = new UDPNetSyslogServerConfig("hostname1",7777);
		assertEquals("hostname1",udpServerConfig.getHost());
		udpServerConfig.setHost("hostname2");
		assertEquals("hostname2",udpServerConfig.getHost());
		assertEquals(7777,udpServerConfig.getPort());

		udpServerConfig = new UDPNetSyslogServerConfig("hostname3");
		assertEquals("hostname3",udpServerConfig.getHost());
	}
	
	public void testSSLTCPNetSyslogConfigCreate() {
		TCPNetSyslogConfig config = null;
		
		config = new SSLTCPNetSyslogConfig();
		assertTrue(config.getSyslogWriterClass() == SSLTCPNetSyslogWriter.class);

		config = new SSLTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH);
		assertTrue(config.getSyslogClass() == SSLTCPNetSyslog.class);
		assertEquals(SyslogConstants.FACILITY_AUTH,config.getFacility());

		config = new SSLTCPNetSyslogConfig("hostname0");
		assertEquals("hostname0",config.getHost());
		config.setHost("hostname1");
		assertEquals("hostname1",config.getHost());

		config = new SSLTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname2");
		assertEquals("hostname2",config.getHost());

		config = new SSLTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname3",2222);
		assertEquals("hostname3",config.getHost());
		assertEquals(2222,config.getPort());
		config.setPort(3333);
		assertEquals(3333,config.getPort());

		config = new SSLTCPNetSyslogConfig("hostname4",4444);
		assertEquals("hostname4",config.getHost());
		assertEquals(4444,config.getPort());
	}
	
	protected void testPoolConfig(PooledTCPNetSyslogConfig config) {
		config.setMaxActive(21);
		assertEquals(21,config.getMaxActive());

		config.setMinIdle(22);
		assertEquals(22,config.getMinIdle());

		config.setMaxWait(23);
		assertEquals(23,config.getMaxWait());

		config.setMinEvictableIdleTimeMillis(24);
		assertEquals(24,config.getMinEvictableIdleTimeMillis());

		config.setNumTestsPerEvictionRun(25);
		assertEquals(25,config.getNumTestsPerEvictionRun());

		config.setTimeBetweenEvictionRunsMillis(26);
		assertEquals(26,config.getTimeBetweenEvictionRunsMillis());

		config.setSoftMinEvictableIdleTimeMillis(27);
		assertEquals(27,config.getSoftMinEvictableIdleTimeMillis());

		config.setTestOnBorrow(false);
		assertFalse(config.isTestOnBorrow());
		config.setTestOnBorrow(true);
		assertTrue(config.isTestOnBorrow());
		config.setTestOnBorrow(false);
		assertFalse(config.isTestOnBorrow());

		config.setTestOnReturn(false);
		assertFalse(config.isTestOnReturn());
		config.setTestOnReturn(true);
		assertTrue(config.isTestOnReturn());
		config.setTestOnReturn(false);
		assertFalse(config.isTestOnReturn());

		config.setTestWhileIdle(false);
		assertFalse(config.isTestWhileIdle());
		config.setTestWhileIdle(true);
		assertTrue(config.isTestWhileIdle());
		config.setTestWhileIdle(false);
		assertFalse(config.isTestWhileIdle());
	}
	
	public void testPooledTCPNetSyslogConfigCreate() {
		PooledTCPNetSyslogConfig config = null;
		
		config = new PooledTCPNetSyslogConfig();
		assertTrue(config.getSyslogWriterClass() == TCPNetSyslogWriter.class);

		config = new PooledTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH);
		assertTrue(config.getSyslogClass() == PooledTCPNetSyslog.class);
		assertEquals(SyslogConstants.FACILITY_AUTH,config.getFacility());

		config = new PooledTCPNetSyslogConfig("hostname0");
		assertEquals("hostname0",config.getHost());
		config.setHost("hostname1");
		assertEquals("hostname1",config.getHost());

		config = new PooledTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname2");
		assertEquals("hostname2",config.getHost());

		config = new PooledTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname3",2222);
		assertEquals("hostname3",config.getHost());
		assertEquals(2222,config.getPort());
		config.setPort(3333);
		assertEquals(3333,config.getPort());

		config = new PooledTCPNetSyslogConfig("hostname4",4444);
		assertEquals("hostname4",config.getHost());
		assertEquals(4444,config.getPort());
		
		testPoolConfig(config);
	}
	
	public void testPooledSSLTCPNetSyslogConfigCreate() {
		PooledTCPNetSyslogConfig config = null;
		
		config = new PooledSSLTCPNetSyslogConfig();
		assertTrue(config.getSyslogWriterClass() == SSLTCPNetSyslogWriter.class);

		config = new PooledSSLTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH);
		assertTrue(config.getSyslogClass() == SSLTCPNetSyslog.class);
		assertEquals(SyslogConstants.FACILITY_AUTH,config.getFacility());

		config = new PooledSSLTCPNetSyslogConfig("hostname0");
		assertEquals("hostname0",config.getHost());
		config.setHost("hostname1");
		assertEquals("hostname1",config.getHost());

		config = new PooledSSLTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname2");
		assertEquals("hostname2",config.getHost());

		config = new PooledSSLTCPNetSyslogConfig(SyslogConstants.FACILITY_AUTH,"hostname3",2222);
		assertEquals("hostname3",config.getHost());
		assertEquals(2222,config.getPort());
		config.setPort(3333);
		assertEquals(3333,config.getPort());

		config = new PooledSSLTCPNetSyslogConfig("hostname4",4444);
		assertEquals("hostname4",config.getHost());
		assertEquals(4444,config.getPort());
		
		testPoolConfig(config);
	}
	
	public void testSyslog4jBackLogHandler() {
		SyslogIF udp = Syslog.getInstance("udp");
		SyslogIF tcp = Syslog.getInstance("tcp");
		
		SyslogBackLogHandlerIF syslog4j = new Syslog4jBackLogHandler("udp");
		syslog4j.initialize();
		
		syslog4j.log(tcp,SyslogConstants.LEVEL_INFO,"Log4j BackLog Test Message - IGNORE","really");
		syslog4j.log(tcp,-1,"Log4j BackLog Test Message - IGNORE","really");
		syslog4j.down(tcp,null);
		syslog4j.up(tcp);

		syslog4j = new Syslog4jBackLogHandler("udp",false);
		
		syslog4j.log(tcp,SyslogConstants.LEVEL_INFO,"Log4j BackLog Test Message - IGNORE","really");
		syslog4j.log(tcp,-1,"Log4j BackLog Test Message - IGNORE","really");
		syslog4j.down(udp,null);
		syslog4j.up(udp);

		syslog4j = new Syslog4jBackLogHandler(udp);
		
		syslog4j.log(tcp,SyslogConstants.LEVEL_INFO,"Log4j BackLog Test Message - IGNORE","really");
		syslog4j.log(tcp,-1,"Log4j BackLog Test Message - IGNORE","really");
		
		syslog4j = new Syslog4jBackLogHandler(udp,false);
		
		syslog4j.log(tcp,SyslogConstants.LEVEL_INFO,"Log4j BackLog Test Message - IGNORE","really");
		syslog4j.log(tcp,-1,"Log4j BackLog Test Message - IGNORE","really");
		
		try {
			syslog4j.log(Syslog.getInstance("udp"),SyslogConstants.LEVEL_INFO,"Log4j BackLog Test Message - IGNORE","really");
			fail();
			
		} catch (SyslogRuntimeException sre) {
			//
		}
	}
	
	public void testSequentialSyslogMessageModifierConfigCreate() {
		SequentialSyslogMessageModifierConfig config = new SequentialSyslogMessageModifierConfig();
		
		assertEquals(SyslogConstants.CHAR_SET_DEFAULT,config.getCharSet());
		config.setCharSet("Unicode");
		assertEquals("Unicode",config.getCharSet());
		
		config.setFirstNumber(500);
		assertEquals(config.getFirstNumber(),500);

		config.setLastNumber(1000);
		assertEquals(config.getLastNumber(),1000);

		config.setLastNumber(499);
		assertEquals(config.getLastNumber(),1000);
		
		config.setFirstNumber(1001);
		assertEquals(config.getFirstNumber(),500);
	}
	
	public void testMultipleSyslogConfigCreate() {
		MultipleSyslogConfig config = new MultipleSyslogConfig();
		assertNotNull(config.getProtocols());
		assertEquals(0,config.getProtocols().size());
		
		config = new MultipleSyslogConfig(new String[] { "tcp", "udp", "unix" });
		assertEquals(3,config.getProtocols().size());
		assertEquals("tcp",config.getProtocols().get(0));
		config.removeProtocol("udp");
		assertEquals(2,config.getProtocols().size());
		assertEquals("unix",config.getProtocols().get(1));
		config.insertProtocol(0,"udp");
		assertEquals("udp",config.getProtocols().get(0));
		config.removeAllProtocols();
		assertEquals(0,config.getProtocols().size());
		config.addProtocol("tcp");
		assertEquals(1,config.getProtocols().size());
		assertEquals("tcp",config.getProtocols().get(0));
		
		List protocols = new ArrayList();
		
		config = new MultipleSyslogConfig(protocols);
		assertTrue(protocols == config.getProtocols());
		assertEquals(0,config.getProtocols().size());
		
		try { config.setCacheHostAddress(true); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setCharSet("foo"); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setFacility(SyslogConstants.FACILITY_AUTH); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setFacility("foo"); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setHost("foo"); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setIdent("foo"); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setLocalName("foo"); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setIncludeIdentInMessageModifier(true); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setPort(9999); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setSendLocalName(true); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setSendLocalTimestamp(true); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setThrowExceptionOnInitialize(true); fail(); } catch (SyslogRuntimeException sre) { }; 
		try { config.setThrowExceptionOnWrite(true); fail(); } catch (SyslogRuntimeException sre) { };
		try { config.setMaxShutdownWait(0); fail(); } catch (SyslogRuntimeException sre) { };
		try { config.setMaxMessageLength(0); fail(); } catch (SyslogRuntimeException sre) { };

		try { config.addBackLogHandler(null); fail(); } catch (SyslogRuntimeException sre) { };		
		try { config.addMessageModifier(null); fail(); } catch (SyslogRuntimeException sre) { };		
		try { config.insertBackLogHandler(0,null); fail(); } catch (SyslogRuntimeException sre) { };		
		try { config.insertMessageModifier(0, null); fail(); } catch (SyslogRuntimeException sre) { };		
		try { config.removeAllBackLogHandlers(); fail(); } catch (SyslogRuntimeException sre) { };		
		try { config.removeAllMessageModifiers(); fail(); } catch (SyslogRuntimeException sre) { };		
		try { config.removeBackLogHandler(null); fail(); } catch (SyslogRuntimeException sre) { };		
		try { config.removeMessageModifier(null); fail(); } catch (SyslogRuntimeException sre) { };

		assertEquals(SyslogConstants.MAX_SHUTDOWN_WAIT_DEFAULT,config.getMaxShutdownWait());
		assertEquals(SyslogConstants.MAX_MESSAGE_LENGTH_DEFAULT,config.getMaxMessageLength());

		assertEquals(SyslogConstants.CHAR_SET_DEFAULT,config.getCharSet());
		assertEquals(SyslogConstants.SYSLOG_FACILITY_DEFAULT,config.getFacility());
		assertEquals(SyslogConstants.SYSLOG_HOST_DEFAULT,config.getHost());
		assertNull(config.getIdent());
		assertEquals(SyslogConstants.SYSLOG_PORT_DEFAULT,config.getPort());
		assertTrue(MultipleSyslog.class == config.getSyslogClass());
		
		assertEquals(SyslogConstants.CACHE_HOST_ADDRESS_DEFAULT,config.isCacheHostAddress());
		assertEquals(SyslogConstants.INCLUDE_IDENT_IN_MESSAGE_MODIFIER_DEFAULT,config.isIncludeIdentInMessageModifier());
		assertEquals(SyslogConstants.SEND_LOCAL_NAME_DEFAULT,config.isSendLocalName());
		assertEquals(SyslogConstants.SEND_LOCAL_TIMESTAMP_DEFAULT,config.isSendLocalTimestamp());
		assertEquals(SyslogConstants.THROW_EXCEPTION_ON_INITIALIZE_DEFAULT,config.isThrowExceptionOnInitialize());
		assertEquals(SyslogConstants.THROW_EXCEPTION_ON_WRITE_DEFAULT,config.isThrowExceptionOnWrite());
	}
	
	public void testModifierParameters() {
		HashSyslogMessageModifierConfig hashConfig = HashSyslogMessageModifierConfig.createSHA160();
		
		assertEquals("SHA1",hashConfig.getHashAlgorithm());
		
		hashConfig.setHashAlgorithm("foo");
		assertEquals("foo",hashConfig.getHashAlgorithm());
		
		byte[] keyBytes = new byte[32];
		for(int i=0; i<32; i++) { keyBytes[i] = 0; }
		
		MacSyslogMessageModifierConfig macConfig = new MacSyslogMessageModifierConfig("HmacSHA256","SHA256",keyBytes);
		
		assertEquals("SHA256",macConfig.getKeyAlgorithm());
		assertEquals("HmacSHA256",macConfig.getMacAlgorithm());
		
		keyBytes[9]=9;
		
		Key k = new SecretKeySpec(keyBytes,"SHA256");
		macConfig.setKey(k);
		
		Key verifyK = macConfig.getKey();
		
		assertTrue(verifyK == k);
		
		MacSyslogMessageModifier mac = new MacSyslogMessageModifier(macConfig);
		assertEquals(mac.getConfig(),macConfig);
		
		SequentialSyslogMessageModifierConfig config = new SequentialSyslogMessageModifierConfig();
		
		config.setPadChar('x');
		assertEquals('x',config.getPadChar());
		
		assertTrue(config.isUsePadding());
		config.setUsePadding(false);
		assertFalse(config.isUsePadding());
	}
	
	public void testUDPNetSyslog() {
		AbstractSyslog syslog = new UDPNetSyslog();
		
		// NO-OP - okay
		syslog.returnWriter(null);
		
		assertNull(syslog.getWriter());
	}
	
	public void testStructuredSyslogMessage() {
		SyslogConfigIF config = new UDPNetSyslogConfig();
		config.setUseStructuredData(true);
		assertTrue(config.isUseStructuredData());
		config.setUseStructuredData(false);
		assertFalse(config.isUseStructuredData());
		
		SyslogIF syslog = Syslog.createInstance("testStructuredSyslog",config);
		
		SyslogMessageProcessorIF messageProcessor = new StructuredSyslogMessageProcessor();
		syslog.setStructuredMessageProcessor(messageProcessor);
		assertEquals(messageProcessor,syslog.getStructuredMessageProcessor());
		
		SyslogMessageIF m1 = new StructuredSyslogMessage("test1",new HashMap(),"test2");
		SyslogMessageIF m2 = new StructuredSyslogMessage("test1",new HashMap(),"test2");
		SyslogMessageIF m3 = new StructuredSyslogMessage("test3",new HashMap(),"test2");
		SyslogMessageIF m4 = new StructuredSyslogMessage("test1",new HashMap(),"test4");
		
		assertFalse(m1.equals(null));
		assertFalse(m1.equals("Wrong Class"));
		assertTrue(m1.equals(m1));
		assertTrue(m2.equals(m2));
		
		assertFalse(m1.equals(m3));
		assertFalse(m1.equals(m4));
	}
	
	public void testStructuredSyslogEvent() {
		InetAddress localhost = null;
		
		try {
			localhost = InetAddress.getLocalHost();
			
		} catch (Exception e) {
			//
		}
		
		String message = "<165> 2003-10-11T22:14:15.003Z hostname appname process-id message-id [id@1234 test1=\"test2\"] test3";
		
		StructuredSyslogServerEvent event = new StructuredSyslogServerEvent(message.getBytes(),message.length(),localhost);
		
		assertEquals("hostname",event.getHost());
		assertEquals("appname",event.getApplicationName());
		assertEquals("process-id",event.getProcessId());
		StructuredSyslogMessage sm = event.getStructuredMessage();
		
		assertEquals("message-id",sm.getMessageId());
		assertEquals("test3",sm.getMessage());
		
		Map map = sm.getStructuredData();
		assertTrue(map.containsKey("id@1234"));
		
		Map item = (Map) map.get("id@1234");
		assertTrue(item.containsKey("test1"));
		assertEquals("test2",item.get("test1"));
		
		String message2 = "3 junk ab [ [ ]";
		StructuredSyslogServerEvent event2 = new StructuredSyslogServerEvent(message2.getBytes(),message2.length(),localhost);
		
		StructuredSyslogMessage sm2 = event2.getStructuredMessage();
		assertEquals(message2,sm2.getMessage());
	}
	
	public void testUnixSocketSyslogConfigParameters() {
		UnixSocketSyslogConfig syslogConfig = new UnixSocketSyslogConfig(SyslogConstants.FACILITY_CRON);
		assertEquals(SyslogConstants.FACILITY_CRON,syslogConfig.getFacility());

		syslogConfig = new UnixSocketSyslogConfig(SyslogConstants.FACILITY_MAIL,"/dev/bar");
		assertEquals(SyslogConstants.FACILITY_MAIL,syslogConfig.getFacility());
		assertEquals("/dev/bar",syslogConfig.getPath());		

		syslogConfig = new UnixSocketSyslogConfig("/dev/baz");
		assertEquals("/dev/baz",syslogConfig.getPath());		

		syslogConfig = new UnixSocketSyslogConfig();

		assertEquals(SyslogConstants.SYSLOG_SOCKET_TYPE_DEFAULT,syslogConfig.getType());
		syslogConfig.setType(SyslogConstants.SOCK_STREAM);
		assertEquals(SyslogConstants.SOCK_STREAM,syslogConfig.getType());
		
		syslogConfig.setType("SOCK_DGRAM");
		assertEquals(SyslogConstants.SOCK_DGRAM,syslogConfig.getType());
		syslogConfig.setType("SOCK_STREAM");
		assertEquals(SyslogConstants.SOCK_STREAM,syslogConfig.getType());

		assertEquals(-1,syslogConfig.getPort());
		assertEquals(null,syslogConfig.getHost());
		assertEquals(-1,syslogConfig.getMaxQueueSize());
		
		assertEquals(SyslogConstants.SYSLOG_SOCKET_FAMILY_DEFAULT,syslogConfig.getFamily());
		syslogConfig.setFamily(SyslogConstants.AF_UNIX);
		assertEquals(SyslogConstants.AF_UNIX,syslogConfig.getFamily());

		syslogConfig.setFamily("AF_UNIX");
		assertEquals(SyslogConstants.AF_UNIX,syslogConfig.getFamily());
		
		assertEquals(SyslogConstants.SYSLOG_SOCKET_PROTOCOL_DEFAULT,syslogConfig.getProtocol());
		syslogConfig.setProtocol(1);
		assertEquals(1,syslogConfig.getProtocol());
		
		assertEquals(SyslogConstants.SYSLOG_SOCKET_PATH_DEFAULT,syslogConfig.getPath());
		syslogConfig.setPath("/dev/foo");
		assertEquals("/dev/foo",syslogConfig.getPath());		

		assertEquals(SyslogConstants.SYSLOG_SOCKET_LIBRARY_DEFAULT,syslogConfig.getLibrary());
		syslogConfig.setLibrary("foolibrary");
		assertEquals("foolibrary",syslogConfig.getLibrary());
		
		assertEquals(UnixSocketSyslog.class,syslogConfig.getSyslogClass());
		
		try {
			syslogConfig.setHost("foo");
			fail();
			
		} catch (SyslogRuntimeException sre) {
			
		}
		
		try {
			syslogConfig.setPort(99);
			fail();
			
		} catch (SyslogRuntimeException sre) {
			
		}
		
		try {
			syslogConfig.setType(null);
			fail();
			
		} catch (SyslogRuntimeException sre) {
			//
		}		

		try {
			syslogConfig.setType("FOO");
			fail();
			
		} catch (SyslogRuntimeException sre) {
			//
		}
		
		assertEquals(SyslogConstants.AF_UNIX,syslogConfig.getFamily());

		try {
			syslogConfig.setFamily(null);
			fail();
			
		} catch (SyslogRuntimeException sre) {
			//
		}		

		try {
			syslogConfig.setFamily("FOO");
			fail();
			
		} catch (SyslogRuntimeException sre) {
			//
		}

		try {
			syslogConfig.setMaxQueueSize(-1);
			fail();
			
		} catch (SyslogRuntimeException sre) {
			//
		}
	}
}
