package componenteLog;

import javax.swing.*;

public class mLogImpl extends JTextArea implements mLog{

    public mLogImpl(){
        super();
        this.setEditable(false);
        this.setRows(10);
        this.setColumns(30);

    }


    @Override
    public void addLogMessage(String message) {
        this.append(message);
    }

    @Override
    public void clearLog() {
        this.setText("");
    }
}
