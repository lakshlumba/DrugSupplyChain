/*
 * Class : WorkQueue.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Nov 10, 2014, 1:29:59 AM
 * ---------------------------------------------------------------------------
 * Change History
 * Develper :
 * Reviwer :
 * Changed ON :
 * ---------------------------------------------------------------------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugsupplychain.neu.css.model.request;


import java.util.ArrayList;

/**
 *
 * @author Laksh
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}
