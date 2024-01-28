package com.market.her.domain.service.transaction;

import com.market.her.domain.TransactionFilter;
import com.market.her.domain.dto.FacturaDto;
import com.market.her.domain.dto.Transaction;
import com.market.her.domain.report.ExportType;
import com.market.her.domain.report.dynamic.DynamicReport;
import com.market.her.domain.service.FacturaService;
import com.market.her.domain.service.report.dynamic.DynamicReportService;
import com.market.her.persistence.entity.Factura;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

  private final DynamicReportService dynamicReportService;
  @Autowired
  private FacturaService facturaService;

  public TransactionService(DynamicReportService dynamicReportService) {
    this.dynamicReportService = dynamicReportService;
  }

  public List<FacturaDto> getTransactionList() {

    List<FacturaDto> listFacturaDto = new ArrayList<>();
    Iterable<Factura> facturaList = facturaService.findAll();
    facturaList.forEach(factura -> {
      FacturaDto facturaDto = new FacturaDto(factura.getNumeroFactura(), factura.getCreateAt().toString(), factura.getTotal(),
              factura.getCliente().getApellido().concat(" ").concat(factura.getCliente().getNombre()),
              factura.getProveedor().getNombre(), "A".equalsIgnoreCase(factura.getEstado()) ? "ACTIVO":"ELIMINADO LOGICO");
      listFacturaDto.add(facturaDto);
    });

    return listFacturaDto;
  }

  public void exportTransactionReport(ExportType exportType, HttpServletResponse response) throws JRException, IOException {
    var filter = new TransactionFilter(exportType);
    var inputStream = filter.getInputStream();
    var title = filter.getReportTitle();
    var list = getTransactionList();

    var report =
        new DynamicReport(
            inputStream,
            title,
            exportType,
            response,
            filter.generateDynamicColumnAndRows(list));

    dynamicReportService.export(report);

    return;
  }
}
