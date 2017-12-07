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
public class Shows {
    
    private int showId;
    private String showName;
    private Time showDuration;
    private Time audioDuration;
    private Time videoDuration;
    private Time advertisingDuration;
    private Time voiceoverDuration;
    private String audioOrMultimedia;
    private int showsrunsperDay;
    private String genre;
    
    public void setShowID(int showId) {
        this.showId = showId;
    }
    
    public int getShowID() {
        return showId;
    }
    
    public void setShowName(String showName) {
        this.showName = showName;
    }
    
    public String getShowName() {
        return showName;
    }
    
    public void setShowDuration(Time showDuration) {
        this.showDuration = showDuration;
    }
    
    public Time getShowDuration() {
        return showDuration;
    }
    
    public void setAudioDuration(Time audioDuration) {
        this.audioDuration = audioDuration;
    }
    
    public Time getAudioDuration() {
        return audioDuration;
    }
    
    public void setVideoDuration(Time videoDuration) {
        this.videoDuration = videoDuration;
    }
    
    public Time getVideoDuration() {
        return videoDuration;
    }
    
    public void setAdvertisingDuration(Time advertisingDuration) {
        this.advertisingDuration = advertisingDuration;
    }
    
    public Time getAdvertisingDuration() {
        return advertisingDuration;
    }
    
    public void setVoiceoverDuration(Time voiveoverDuration) {
        this.voiceoverDuration = voiveoverDuration;
    }
    
    public Time getVoiceoverDuration() {
        return voiceoverDuration;
    }
    
    public void setAudioOrMultimedia(String audioOrMultimedia) {
        this.audioOrMultimedia = audioOrMultimedia;
    }
    
    public String getAudioOrMultimedia() {
        return audioOrMultimedia;
    }
    
    public void setShowsRunsPerDay(int showsRunsPerDay) {
        this.showsrunsperDay = showsRunsPerDay;
    }
    
    public int getShowsRunsPerDay() {
        return showsrunsperDay;
    }
     
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getGenre() {
        return genre;
    }
    
}
