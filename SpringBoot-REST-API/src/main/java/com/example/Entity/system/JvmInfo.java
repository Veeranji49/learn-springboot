package com.example.Entity.system;

import java.io.Serializable;

public class JvmInfo implements Serializable {


    private String jvmName;
    private String jvmVendor;
    private String jvmVersion;

    //PDC
    public JvmInfo() {}

    //PPC
    public JvmInfo(String jvmName, String jvmVendor, String jvmVersion) {
        super();
        this.jvmName = jvmName;
        this.jvmVendor = jvmVendor;
        this.jvmVersion = jvmVersion;
    }

    //PGM & PSM
    public String getJvmName() {
        return jvmName;
    }

    public void setJvmName(String jvmName) {
        this.jvmName = jvmName;
    }

    public String getJvmVendor() {
        return jvmVendor;
    }

    public void setJvmVendor(String jvmVendor) {
        this.jvmVendor = jvmVendor;
    }

    public String getJvmVersion() {
        return jvmVersion;
    }

    public void setJvmVersion(String jvmVersion) {
        this.jvmVersion = jvmVersion;
    }

}
