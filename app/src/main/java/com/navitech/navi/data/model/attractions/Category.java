package com.navitech.navi.data.model.attractions;

import static com.navitech.navi.utils.Constants.KEY_DESCRIPTION;
import static com.navitech.navi.utils.Constants.KEY_NAME;
import static com.navitech.navi.utils.Constants.KEY_TAG;

import com.navitech.navi.data.model.GenericModel;
import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;

@ParseClassName("category")
public class Category extends GenericModel implements Serializable {
    public Category(){}

    public Category(int tag) {
        setTag(tag);
    }

    public String getName() {
        return getString(KEY_NAME);
    }

    public void setName(String name) {
        put(KEY_NAME, name);
    }

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String name) {
        put(KEY_DESCRIPTION, name);
    }

    public int getTag() {
        return getInt(KEY_TAG);
    }

    public void setTag(int tag) {
        put(KEY_TAG, tag);
    }
}
