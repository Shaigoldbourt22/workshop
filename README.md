# workshop

Classes:
File - a class to represent a file

FileConverter - a class to convert a json node of a file to an object File

Record - a class to represent a Record

RecordConverter - a class to convert a json node of a record to an object Record

ZenodoRecordSearch -  a class to search a Zenodo Record


Testers:
unit:
FileTest - a test for the File class

RecordTest - a test for the Record class

FileConverterTest - a test for the FileConvertor

RecordConverterTest - a test for the RecordConverter

ZenodoRecordSearchTester - a test for the ZenodoRecordSearch 

integration:
ZenodoRecordSearchAndConverterTester - a test for searching a record and creating a Record objact from 
it

ZenodoRecordSearchAndFileConverterTest - a test for searching a record and creating a File object from
the first file found
