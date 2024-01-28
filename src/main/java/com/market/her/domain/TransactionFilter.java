package com.market.her.domain;

import com.market.her.domain.dto.FacturaDto;
import com.market.her.domain.dto.Transaction;
import com.market.her.domain.report.ExportType;
import com.market.her.domain.report.dynamic.DynamicReportProperties;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.market.her.util.Constant.EXTENSION_JRXML;
import static com.market.her.util.Constant.FOLDER_PATH_REPORT_DYNAMIC;


public class TransactionFilter {
  ExportType exportType;

  public TransactionFilter(ExportType exportType) {
    this.exportType = exportType;
  }

  public InputStream getInputStream() {
    var name = FOLDER_PATH_REPORT_DYNAMIC + this.exportType.toString().toLowerCase() + EXTENSION_JRXML;
    return getClass().getResourceAsStream(name);
  }

  public String getReportTitle() {
    return  "Transaction Summary Report";
  }

  public DynamicReportProperties generateDynamicColumnAndRows(List<FacturaDto> list) {
    var totalVolume = Integer.valueOf(0);
    var totalAmount = Double.valueOf(0.00);
    DecimalFormat df = new DecimalFormat("#,###.###");

    List<String> columnHeaders = new ArrayList<>();
    List<Integer> indexesOfColumnTypeNumber = new ArrayList<>();
    List<List<String>> rows = new ArrayList<>();
    List<String> summary = new ArrayList<>();

    // dynamic

    // static
    columnHeaders.add("Date");
    columnHeaders.add("Num factura");
    columnHeaders.add("Proveedor");
    columnHeaders.add("Cliente");
    columnHeaders.add("Total\n(TK)");

    for (var s : list) {
      List<String> row = new ArrayList<>();
      row.add(String.valueOf(s.getFecha()));
      row.add(s.getNumeroFactura());
      row.add(s.getProveedor());
      row.add(s.getCliente());
      row.add(String.valueOf(s.getTotal()));

      rows.add(row);

      // sum
      totalAmount+=s.getTotal();
    }
      totalVolume =list.size();

    // summary
    summary.add("Total");
    summary.add(df.format(totalVolume).toString());
    summary.add(df.format(totalAmount).toString());
    summary.add(null);

    // number field index list
    indexesOfColumnTypeNumber.add(columnHeaders.size() - 4); // "Total"
    indexesOfColumnTypeNumber.add(columnHeaders.size() - 3); // totalVolume
    indexesOfColumnTypeNumber.add(columnHeaders.size() - 2); // totalAmount
    indexesOfColumnTypeNumber.add(columnHeaders.size() - 1); // totalAmount

    return new DynamicReportProperties(columnHeaders, indexesOfColumnTypeNumber, rows, summary);
  }
}
