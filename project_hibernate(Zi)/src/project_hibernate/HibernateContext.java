package project_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sean
 */
public class HibernateContext {
    
    public static AnnotationConfiguration config = null;
    public static SessionFactory factory = null;
    
    /**
     * Set the configuration if it is null
     */
    private static void setConfiguration() {
  
        if (config == null) {
            config = new AnnotationConfiguration();
            config.configure();
        }
    }
    
    /**
     * Set the factory if it is null
     */
    private static void setFactory() {
        
        if(factory == null) {
            setConfiguration();
            factory = config.buildSessionFactory();
        }
    }
    
    /**
     * Open a session form the factory
     * @return a session
     */
    public static Session getSession() {
        
        setFactory();
        return factory.openSession();
    }
    
    /**
     * Create a new schema from the configuration
     */
    public static void createSchema() {
        
        setConfiguration();
        (new SchemaExport(config)).create(true, true);
    }
    
    /**
     * Add a new class object to the database
     * @param clas the class object
     */
    public static void addClass(Class clas) {
        
        setConfiguration();
        config.addAnnotatedClass(clas);
    }
    
    /**
     * Add a list of class objects to the database
     * @param clases the list of class objects
     */
    public static void addClasses(Class[] clases) {
        
        for(Class clas : clases) {
            addClass(clas);
        }
    }
    
}
