package br.com.xmacedo.generatebarandqrcode.controller;

import br.com.xmacedo.generatebarandqrcode.service.BarcodeServiceImpl;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api")
public class BarcodeController {

    @Autowired
    private BarcodeServiceImpl barcodeService;

    @GetMapping(value = "/{type}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateCode(@PathVariable String type, @RequestParam String text) {
        byte[] code;
        try {
            return switch (type.toLowerCase()) {
                case "qrcode" -> {
                    code = barcodeService.generateQRCode(text);
                    yield ResponseEntity.ok(code);
                }
                case "barcode" -> {
                    code = barcodeService.generateBarcode(text);
                    yield ResponseEntity.ok(code);
                }
                default -> ResponseEntity.badRequest().body(null); // 400 Bad Request for invalid type
            };
        } catch (WriterException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
