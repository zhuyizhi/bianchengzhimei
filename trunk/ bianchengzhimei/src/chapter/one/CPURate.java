//package chapter.one;
////import java.lang.management.*;
////import sun.management.ManagementFactoryHelper;/
//import sun.management.ManagementFactoryHelper;
//
//import com.sun.management.*;
///**
// * Ã»×ö
// * @author ucai
// *
// */
//public class CPURate {
//	
//	public static void main(String[] args)throws Exception{
////		OperatingSystemMXBean bean = (OperatingSystemMXBean)ManagementFactoryHelper.getOperatingSystemMXBean();
//		PerformanceMonitor pm = new PerformanceMonitor();
//		System.out.println(pm.getCpuUsage());
//		Thread.sleep(1000);
//		System.out.println(pm.getCpuUsage());
//		System.out.println(pm.getCpuUsage());
//		System.out.println(pm.getCpuUsage());
//	}
//
//}
//
//
//class PerformanceMonitor { 
//    private int  availableProcessors = ManagementFactoryHelper.getOperatingSystemMXBean().getAvailableProcessors();
//    private long lastSystemTime      = 0;
//    private long lastProcessCpuTime  = 0;
//
//    public synchronized double getCpuUsage()
//    {
//        if ( lastSystemTime == 0 )
//        {
//            baselineCounters();
//            return 0;
//        }
//
//        long systemTime     = System.nanoTime();
//        long processCpuTime = 0;
//
//        if ( ManagementFactoryHelper.getOperatingSystemMXBean() instanceof OperatingSystemMXBean )
//        {
//            processCpuTime = ( (OperatingSystemMXBean) ManagementFactoryHelper.getOperatingSystemMXBean() ).getProcessCpuTime();
//        }
//
//        double cpuUsage = (double) ( processCpuTime - lastProcessCpuTime ) / ( systemTime - lastSystemTime );
//
//        lastSystemTime     = systemTime;
//        lastProcessCpuTime = processCpuTime;
//
//        return cpuUsage / availableProcessors;
//    }
//
//    private void baselineCounters()
//    {
//        lastSystemTime = System.nanoTime();
//
//        if ( ManagementFactoryHelper.getOperatingSystemMXBean() instanceof OperatingSystemMXBean )
//        {
//            lastProcessCpuTime = ( (OperatingSystemMXBean) ManagementFactoryHelper.getOperatingSystemMXBean() ).getProcessCpuTime();
//        }
//    }
//}