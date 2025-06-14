# Generate Bar and QR Code

## Prerequisites
This is the list of all the prerequisites:

- Spring Boot 3+
- Maven 3.6.3
- Java 21

## Overview
### Barcodes

A barcode or bar code is a method of representing data in a visual, machine-readable form. 
Initially, barcodes represented data by varying the widths, spacings, and sizes of parallel lines.

https://en.wikipedia.org/wiki/Barcode

#### Types of Barcodes
- 1D Barcodes (Linear Barcodes): These are the traditional barcodes with parallel lines. 
They represent data using the width and spacing of the bars. Examples include:
- UPC (Universal Product Code): Used on most retail products.
- EAN (European Article Number): Similar to UPC, used internationally.
- Code 39: Often used in automotive and defense industries.
- Code 128: Used for shipping labels and packaging.

### QR Codes
A QR code, quick-response code,[1](https://en.wikipedia.org/wiki/QR_code#cite_note-1) is a type of [two-dimensional](https://en.wikipedia.org/wiki/Plane_(mathematics))
[matrix barcode](https://en.wikipedia.org/wiki/Barcode#Matrix_(2D)_codes) invented in 1994 by [Masahiro Hara](https://en.wikipedia.org/wiki/Masahiro_Hara)
of Japanese company Denso Wave for labelling automobile parts.

#### Structure of QR Codes
- 2D Barcodes: QR codes (Quick Response codes) are two-dimensional codes with black squares arranged on a white grid. 
They can store significant data, including URLs, text, and other information.

#### How QR Codes Work
- Data Encoding: QR codes can encode various data types, including numeric, alphanumeric, binary, and Kanji characters. 
The data is converted into a binary format and then represented as a pattern of squares.
- QR Code Generation: QR code generation software converts the encoded data into a visual QR code format. 
It can be used with various libraries or online tools.
- Printing: The generated QR code can be printed on labels, packaging, or displayed on screens.
- A QR code scanner (often a smartphone camera or a dedicated QR code reader) captures the image of the QR code.
- The scanner analyzes the pattern of squares and converts it into a binary format.
- The binary data is then decoded back into the original information.
- Data Retrieval: The decoded data can be used to perform various actions, such as opening a URL in a web browser, 
displaying text, or adding a contact to a phone.


### Getting Started


#### Add Dependencies
We’ll use the ZXing library for 1D Barcode and QR Code Generation.
Add the necessary dependencies for barcode and QR code generation to your

Specific Libraries to Generate that:
```xml
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>javase</artifactId>
    <version>3.5.3</version>
</dependency>
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>core</artifactId>
    <version>3.5.3</version>
</dependency>
```


### Test the REST APIs
#### Generate a QR Code
- URL: http://localhost:8080/api/qrcode?text=HellorrrrWorld
- Method: GET
- Response: A PNG image of the QR code.


#### Generate a Barcode
- URL: http://localhost:8080/api/barcode?text=12345678292
- Method: GET
- Response: A PNG image of the barcode



### References
- https://github.com/zxing/zxing
- https://en.wikipedia.org/wiki/Barcode
- https://en.wikipedia.org/wiki/QR_code