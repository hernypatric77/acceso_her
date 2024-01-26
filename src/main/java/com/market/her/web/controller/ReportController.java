package com.market.her.web.controller;

import com.market.her.domain.report.ExportType;
import com.market.her.domain.service.report.ReportService;
import com.market.her.domain.service.transaction.TransactionService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(path = "/reports")
public class ReportController {

  @Autowired
  private ReportService reportService;
  @Autowired
  private TransactionService transactionService;


  @GetMapping(value = "transactions/download")
  public ResponseEntity<Void> downloadTransactionReport(ExportType exportType,
                                                        HttpServletResponse response) throws IOException, JRException {
    reportService.downloadTransactionReport(exportType, response);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "dynamic/transactions/download")
  public ResponseEntity<Void> exportDynamicTransactionReport(ExportType exportType, HttpServletResponse response) throws IOException, JRException {
    transactionService.exportTransactionReport(exportType, response);
    return ResponseEntity.ok().build();
  }
}
