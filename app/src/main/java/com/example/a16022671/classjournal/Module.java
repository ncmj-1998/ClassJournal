package com.example.a16022671.classjournal;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable {
    public String moduleName;
    public String moduleCode;
    public ArrayList<String> dailyGrade;
    public String moduleUrl;

    public Module(String moduleCode, String moduleName) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.dailyGrade = null;

    }

    public Module(String moduleCode, String moduleName,ArrayList<String>dailyGrade) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.dailyGrade = dailyGrade;
    }

    public void addToArray (String grade){
        dailyGrade.add(grade);
    }


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public ArrayList<String> getDailyGrade() {
        return dailyGrade;
    }

    public void setDailyGrade(ArrayList<String> dailyGrade) {
        this.dailyGrade = dailyGrade;
    }
}
