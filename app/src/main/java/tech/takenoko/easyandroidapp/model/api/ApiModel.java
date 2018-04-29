package tech.takenoko.easyandroidapp.model.api;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 * Created by takenoko on 2018/04/29.
 */
@Data
public class ApiModel implements Serializable {
    String base;
    String date;
    Map<String, String> rates;
}
