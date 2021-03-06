package bitsSearch.models;

import java.util.Date;
import java.io.File;
public class IndexFile {
    private String fileName;
    private Date indexTime;
    private Boolean exists;

    public Date getIndexTime() {
        return indexTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setIndexTime(Date indexTime) {
        this.indexTime = indexTime;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    public boolean hasBeenModified() {
        int answer = indexTime.compareTo(new Date(new File(fileName).lastModified()));
        return answer < 0;
    }
}
