package com.market.her.domain.report.dynamic;

import com.market.her.domain.report.ExportType;
import com.market.her.domain.report.Report;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class DynamicReport extends Report {
  private final DynamicReportProperties dynamicReportProperties;

  public DynamicReport(
      InputStream inputStream,
      String title,
      ExportType exportType,
      HttpServletResponse response,
      DynamicReportProperties dynamicReportProperties) {
    super(inputStream, title, null, exportType, response);
    this.dynamicReportProperties = dynamicReportProperties;
  }

  public DynamicReportProperties getDynamicReportProperties() {
    return dynamicReportProperties;
  }
}
