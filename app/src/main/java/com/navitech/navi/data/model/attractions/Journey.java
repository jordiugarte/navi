package com.navitech.navi.data.model.attractions;

import static com.navitech.navi.utils.Constants.KEY_ATTRACTION;

import com.navitech.navi.data.model.GenericModel;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;

@ParseClassName("journey")
public class Journey extends GenericModel implements Serializable {
    public ParseObject getAttraction() {
        return getParseObject(KEY_ATTRACTION);
    }

    public void setAttraction(ParseObject attraction) {
        put(KEY_ATTRACTION, attraction);
    }
}
