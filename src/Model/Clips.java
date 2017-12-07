/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;

/**
 *
 * @author nishan
 */
public class Clips {
    
    private int clipId;
    private String clipName;
    private Time clipDuration;
    private String clipType;
    private boolean advertisement;
    private int timesPlayedAccrossStation;
    private int maxTimeCanPlayedInCurrentStation;
    private int minTimeMustPlayedInCurrentStation;
    private String genre;
    
    public void setClipId(int clipId) {
        this.clipId = clipId;
    }
    
    public int getClipId() {
        return clipId;
    }
    
    public void setClipName(String clipName) {
        this.clipName = clipName;
    }
    
    public String getClipName() {
        return clipName;
    }
    
    public void setClipDuration(Time clipDuration) {
        this.clipDuration = clipDuration;
    }
    
    public Time getClipDuration() {
        return clipDuration;
    }
    
    public void setClipType(String clipType) {
        this.clipType = clipType;
    }
    
    public String getClipType() {
        return clipType;
    }
    
    public void setAdvertisement(boolean advertisement) {
        this.advertisement = advertisement;
    }
    
    public boolean getAdvertisement() {
        return advertisement;
    }
    
    public void setTimesPlayedAccrossStation(int timesPlayedAccrossStation) {
        this.timesPlayedAccrossStation = timesPlayedAccrossStation;
    }
    
    public int getTimesPlayedAccrossStation() {
        return timesPlayedAccrossStation;
    }
    
    public void setMaxTimeCanPlayedInCurrentStation(int maxTimeCanPlayedInCurrentStation) {
        this.maxTimeCanPlayedInCurrentStation = maxTimeCanPlayedInCurrentStation;
    }
    
    public int getMaxTimeCanPlayedInCurrentStation() {
        return maxTimeCanPlayedInCurrentStation;
    }
    
    public void setMinTimeMustPlayedInCurrentStation(int minTimeMustPlayedInCurrentStation) {
        this.minTimeMustPlayedInCurrentStation = minTimeMustPlayedInCurrentStation;
    }
    
    public int getMinTimeMustPlayedInCurrentStation() {
        return minTimeMustPlayedInCurrentStation;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getGenre() {
        return genre;
    }
    
}
