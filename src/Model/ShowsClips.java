/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nishan
 */
public class ShowsClips {
    
    private int showsClipId;
    private int showsId;
    private int clipsId;
    
    public void setShowsClipId(int showsClipId) {
        this.showsClipId = showsClipId;
    }
    
    public int getShowsClipId() {
        return showsClipId;
    }
    
    public void setShowsId(int showsId) {
        this.showsId = showsId;
    }
    
    public int getShowsId() {
        return showsId;
    }
    
    public void setClipId(int clipId) {
        this.clipsId = clipId;
    }
    
    public int getClipId() {
        return clipsId;
    }
}
