package config;

import com.gizbel.excel.annotations.ExcelColumnHeader;
import com.gizbel.excel.annotations.ExcelColumnIndex;

public class Bean {
	
	@ExcelColumnHeader(columnHeader = "Company Name", dataType = "string")
    public String companyName;

    @ExcelColumnIndex(columnIndex = "Email ID", dataType = "string")
    public String emailID;
}
