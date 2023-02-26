package egovframework.example.cmmn.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Data;

@Data
public class DataTableVO {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;

    private List<?> data;

    public List<?> getData() {
        if (CollectionUtils.isEmpty(data)) {
            data = new ArrayList();
        }
        return data;
    }

}
