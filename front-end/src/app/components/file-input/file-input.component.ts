
import AWSS3UploadAshClient from 'aws-s3-upload-ash';
import { UploadResponse } from 'aws-s3-upload-ash/dist/types';
import { environment } from '../../../environments/environment';
import { Component, OnInit } from '@angular/core';
import { UploadService } from '../../Services/upload.service';


@Component({
  selector: 'app-file-input',
  templateUrl: './file-input.component.html',
  styleUrls: ['./file-input.component.css']
})
export class FileInputComponent {

  
  selectedFiles!: FileList;

  constructor(private uploadService: UploadService) { }
  
  ngOnInit() {
  }
  
  upload() {
  const file = this.selectedFiles.item(0);
  this.uploadService.uploadFile(file);
  console.log(file)
  }
  
  selectFile(event) {
  this.selectedFiles = event.target.files;
  }
}
