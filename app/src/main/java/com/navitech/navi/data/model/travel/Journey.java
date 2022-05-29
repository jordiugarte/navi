package com.navitech.navi.data.model.travel;

import static com.navitech.navi.utils.Constants.KEY_ATTRACTION;
import static com.navitech.navi.utils.Constants.KEY_END_DATE;
import static com.navitech.navi.utils.Constants.KEY_PARTICIPANTS;
import static com.navitech.navi.utils.Constants.KEY_START_DATE;
import static com.navitech.navi.utils.Constants.KEY_SUB_TOTAL;

import com.navitech.navi.data.model.GenericModel;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;
import java.util.Date;

@ParseClassName("journey")
public class Journey extends GenericModel implements Serializable {

    public ParseObject getAttraction() {
        return getParseObject(KEY_ATTRACTION);
    }

    public void setAttraction(ParseObject attraction) {
        put(KEY_ATTRACTION, attraction);
    }

    public Date getStartDate() {
        return getDate(KEY_START_DATE);
    }

    public void setStartDate(Date startDate) {
        put(KEY_START_DATE, startDate);
    }

    public Date getEndDate() {
        return getDate(KEY_END_DATE);
    }

    public void setEndDate(Date endDate) {
        put(KEY_END_DATE, endDate);
    }

    public int getParticipants() {
        return getInt(KEY_PARTICIPANTS);
    }

    public void setParticipants(int participants) {
        put(KEY_PARTICIPANTS, participants);
    }

    public int getSubTotal() {
        return getInt(KEY_SUB_TOTAL);
    }

    public void setSubTotal(int subTotal) {
        put(KEY_SUB_TOTAL, subTotal);
    }
}
