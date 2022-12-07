import { Injectable } from '@angular/core';
//import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';

@Injectable({
  providedIn: 'root',
})
export class UploadService {

   id !: number 
   dataLocation !: any

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

    let dataUrl = bucket.upload(params, function (err, data) : string {
      if (err) {
        console.log('There was an error uploading your file: ', err);
        return "Error";
      }

     
      console.log('Successfully uploaded file.', data);
      
      console.log('image path is ' + data.Location);
      return data.Location;
    });

    return dataUrl
  }
}
