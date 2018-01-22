
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import weka.classifiers.Classifier;
import java.io.Serializable;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.FastVector;
import weka.core.Instances;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cse
 */
public class weka {
    
    public String ClassifyInstance( String[] features) throws IOException, ClassNotFoundException, Exception
    {
        //String cl="";
        ObjectInputStream ois = new ObjectInputStream(
                           new FileInputStream("chronic_kidney_disease.model"));// load model
        Classifier classifier = (Classifier) ois.readObject();
        ois.close();
        Instance newIns = createInstance(features);// create new Instance
        double cls = classifier.classifyInstance(newIns);// classify the new instance
        System.out.print(classifier.classifyInstance(newIns));
        return Double.toString(cls);// return class
                
        
    }
    public Instance createInstance(String[] features)
    {
        System.out.println(features);
        //declaring attributes
        // deeclare numeric attribute
        FastVector myNomVals = new FastVector();
        Attribute Attribute1 = new Attribute("age");
        Attribute Attribute2 = new Attribute("bp");
        // declare nominal attribute
        FastVector fvNominalVal = new FastVector(5);
        fvNominalVal.addElement("0");
        fvNominalVal.addElement("1");
        fvNominalVal.addElement("2");
        fvNominalVal.addElement("3");
        fvNominalVal.addElement("4");   
        fvNominalVal.addElement("5");   
        Attribute Attribute3 = new Attribute("su",fvNominalVal);
        
        FastVector fvNominalVal1 = new FastVector(2);
        fvNominalVal1.addElement("normal");
        fvNominalVal1.addElement("abnormal");            
        Attribute Attribute4 = new Attribute("rbc",fvNominalVal1);
        
        FastVector fvNominalVal2 = new FastVector(2);
        fvNominalVal2.addElement("present");
        fvNominalVal2.addElement("notpresent"); 
        Attribute Attribute5 = new Attribute("ba",fvNominalVal2);
        
        Attribute Attribute6 = new Attribute("sod");
        Attribute Attribute7 = new Attribute("pot");
        Attribute Attribute8 = new Attribute("hemo");
        Attribute Attribute9 = new Attribute("wbcc");
        Attribute Attribute10 = new Attribute("rbcc");
        
        FastVector fvNominalVal3 = new FastVector(2);
        fvNominalVal3.addElement("yes");
        fvNominalVal3.addElement("no"); 
        Attribute Attribute11 = new Attribute("htn",fvNominalVal3);
       
        Attribute Attribute12 = new Attribute("dm",fvNominalVal3);
        
        Attribute Attribute13 = new Attribute("cad",fvNominalVal3);
        
        FastVector fvClassVal = new FastVector(2);
        fvClassVal.addElement("ckd");
        fvClassVal.addElement("notckd");
        Attribute Class = new Attribute("class", fvClassVal);
        // add all the attribute in the weka attributes list
        FastVector fvWekaAttributes = new FastVector(14);
        fvWekaAttributes.addElement(Attribute1);
        fvWekaAttributes.addElement(Attribute2);
        fvWekaAttributes.addElement(Attribute3);
        fvWekaAttributes.addElement(Attribute4);
        fvWekaAttributes.addElement(Attribute5);
        fvWekaAttributes.addElement(Attribute6);
        fvWekaAttributes.addElement(Attribute7);
        fvWekaAttributes.addElement(Attribute8);
        fvWekaAttributes.addElement(Attribute9);
        fvWekaAttributes.addElement(Attribute10);
        fvWekaAttributes.addElement(Attribute11);
        fvWekaAttributes.addElement(Attribute12);
        fvWekaAttributes.addElement(Attribute13);
        fvWekaAttributes.addElement(Class);
        
        Instances dataset = new Instances("whatever", fvWekaAttributes, 0);
        dataset.setClassIndex(dataset.numAttributes()-1);
        Instance iExample = new DenseInstance(features.length);
        
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(0), Double.parseDouble(features[0]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), Double.parseDouble(features[1]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), features[2]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), features[3]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(4), features[4]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(5), Double.parseDouble(features[5]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(6), Double.parseDouble(features[6]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(7), Double.parseDouble(features[7]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(8), Double.parseDouble(features[8]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(9), Double.parseDouble(features[9]));
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(10), features[10]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(11), features[11]);
        iExample.setValue((Attribute)fvWekaAttributes.elementAt(12), features[12]);
         
        dataset.add(iExample);
        
        return dataset.instance(0);
       
        
    }
    
}
