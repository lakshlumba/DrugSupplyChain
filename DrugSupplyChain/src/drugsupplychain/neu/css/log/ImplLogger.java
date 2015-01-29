/*
 * Class : ImplLogger.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Oct 19, 2014, 4:50:36 PM
 * ---------------------------------------------------------------------------
 * Change History
 * Develper :
 * Reviwer :
 * Changed ON :
 * ---------------------------------------------------------------------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugsupplychain.neu.css.log;
/**
 *
 * @author Laksh
 */
import drugsupplychain.neu.css.util.ImplConst;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Priority;

public class ImplLogger extends SecurityManager {

    private static final ConcurrentHashMap<String, org.apache.log4j.Logger> loggerMap = new ConcurrentHashMap<String, org.apache.log4j.Logger>();
    
    public static final org.apache.log4j.Logger getLog() {        
        String className = new ImplLogger().getClassName();
        if (!loggerMap.containsKey(className)) {
            loggerMap.put(className, org.apache.log4j.Logger.getLogger(className));
        }
        return loggerMap.get(className);
    }
    public String getClassName() {
        return getClassContext()[3].getName();
    }
    public static final void trace(Object message) {
        getLog().trace(message);
    }
    public static final void trace(Object message, Throwable t) {
        getLog().trace(message, t);
    }
    public static final boolean isTraceEnabled() {
        return getLog().isTraceEnabled();
    }
    public static final void debug(Object message) {
        getLog().debug(message);
    }
    public static final void debug(Object message, Throwable t) {
        getLog().debug(message, t);
    }
    public static final void error(Object message) {
        getLog().error(message);
    }
    public static final void error(Object message, Throwable t) {
        getLog().error(message, t);
    }
    public static final void fatal(Object message) {
        getLog().fatal(message);
    }
    public static final void fatal(Object message, Throwable t) {
        getLog().fatal(message, t);
    }
    public static final void info(Object message) {
        getLog().info(message);
    }
    public static final void info(Object message, Throwable t) {
        getLog().info(message, t);
    }
    public static final boolean isDebugEnabled() {
        return getLog().isDebugEnabled();
    }
    public static final boolean isEnabledFor(Priority level) {
        return getLog().isEnabledFor(level);
    }
    public static final boolean isInfoEnabled() {
        return getLog().isInfoEnabled();
    }
    public static final void setLevel(Level level) {
        getLog().setLevel(level);
    }
    public static final void warn(Object message) {
        getLog().warn(message);
    }
    public static final void warn(Object message, Throwable t) {
        getLog().warn(message, t);
    }
    
    public static final String getCallingMethod() {  
        StackTraceElement[] stack = new Throwable().getStackTrace();  
        StackTraceElement ste = null;  
        if (stack.length > 2)   
            ste = stack[2];  
        return ste == null ? ImplConst.UNAVAILABLE : ste.getMethodName(); 
    }
    
    public static final void enterMethod(){
        String methodName = ImplConst.ENTERING_METHOD + ImplConst.SPACE + getCallingMethod();
        getLog().info(methodName);
    }
    public static final void exitMethod(){
        String methodName = ImplConst.EXITING_METHOD + ImplConst.SPACE + getCallingMethod();
        getLog().info(methodName);
    }
}