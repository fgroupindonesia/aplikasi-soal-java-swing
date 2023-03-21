package fgroupindonesia.helper;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author fgroupindonesia
 */
public class QJSONHelper {

    // this is question in json format
    private String data;
    private JTextArea textarea;
    private JLabel questionNumberLabel;
    private JRadioButton jr1;
    private JRadioButton jr2;
    private JRadioButton jr3;
    private JRadioButton jr4;

    public void renderAll(){
        
    }
    
    public void setQuestionNumberLabel(JLabel j) {
        questionNumberLabel = j;
    }

    public void setData(String n) {
        data = n;

    }

    public void next() {

    }

    public void previous() {

    }

    public void setStatus() {

    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @return the questionNumberLabel
     */
    public JLabel getQuestionNumberLabel() {
        return questionNumberLabel;
    }

    /**
     * @return the jr1
     */
    public JRadioButton getJr1() {
        return jr1;
    }

    /**
     * @param jr1 the jr1 to set
     */
    public void setJr1(JRadioButton jr1) {
        this.jr1 = jr1;
    }

    /**
     * @return the jr2
     */
    public JRadioButton getJr2() {
        return jr2;
    }

    /**
     * @param jr2 the jr2 to set
     */
    public void setJr2(JRadioButton jr2) {
        this.jr2 = jr2;
    }

    /**
     * @return the jr3
     */
    public JRadioButton getJr3() {
        return jr3;
    }

    /**
     * @param jr3 the jr3 to set
     */
    public void setJr3(JRadioButton jr3) {
        this.jr3 = jr3;
    }

    /**
     * @return the jr4
     */
    public JRadioButton getJr4() {
        return jr4;
    }

    /**
     * @param jr4 the jr4 to set
     */
    public void setJr4(JRadioButton jr4) {
        this.jr4 = jr4;
    }

    /**
     * @return the textarea
     */
    public JTextArea getTextarea() {
        return textarea;
    }

    /**
     * @param textarea the textarea to set
     */
    public void setTextarea(JTextArea textarea) {
        this.textarea = textarea;
    }

}
