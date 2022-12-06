import { Injectable } from '@angular/core';
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';

@Injectable({
  providedIn: 'root',
})
export class UploadService {

   id: number = 1;

  constructor() {}

  bucket = new S3({
    accessKeyId: 'AKIA5NLZFIEYMCCMEUOK',
    secretAccessKey: 'Xz54v40grBef68yrWyiLXxddIoxhIcTKfiLYwDhY',
    region: 'YOUR-REGION',
  });

  uploadFile(file) {
    const contentType = file.type;
    const bucket = new S3({
      accessKeyId: 'AKIA5NLZFIEYMCCMEUOK',
      secretAccessKey: 'Xz54v40grBef68yrWyiLXxddIoxhIcTKfiLYwDhY',
      region: 'sa-east-1',
    });

    const params = {
      Bucket: 'shopcar-t2',
      Key: `media/img${this.id}`,
      Body: file,
      ACL: 'public-read',
      ContentType: contentType,
    };

    bucket.upload(params, function (err, data) {
      if (err) {
        console.log('There was an error uploading your file: ', err);
        return false;
      }

     
      console.log('Successfully uploaded file.', data);
      
      console.log('image path is ' + data.Location);
      return true;
    });

    this.id ++ ;
    //for upload progress
    /*bucket.upload(params).on('httpUploadProgress', function (evt) {
          console.log(evt.loaded + ' of ' + evt.total + ' Bytes');
      }).send(function (err, data) {
          if (err) {
              console.log('There was an error uploading your file: ', err);
              return false;
          }
          console.log('Successfully uploaded file.', data);
          return true;
      });*/
  }
}
