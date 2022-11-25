export interface Login {
    username: string;
    password: string;
}

export interface AnnouncementList {
    id: number;
    amount: number;
    user: User;
    date: string;
    product: Product;
}

export interface Adress {
    cep: string;
    logradouro?: string;
    complemento: string;
    bairro?: string;
    localidade: string;
    uf: string;
}

export interface User {
    id: number;
    name: string;
    email: string;
    birthDate?: string;
    login?: Login;
    announcementList?: AnnouncementList[];
    nacionalNumber?: string;
    descriminationColumn?: string;
    fone: string;
    adress?: Adress;
}

export interface Order {
    id: number;
    user: User;
    subTotal: number;
    discount: number;
    produtos: Product[];
}

export interface CommentAnswerDto {
    idCommentAnswer: number;
    message: string;
    user?: User;
    comment?: Comment;
    timeCreated: Date;
}

export interface Comment {
    id: number;
    message: string;
    user?: User;
    announcement? : Announce;
    commentAnswerDtos: CommentAnswerDto[];
}

export interface Announce {
    id: number;
    user: User;
    amount: number;
    date: Date;
    comments?: Comment[];
    product: Product;
}

export interface Product {
    id: number;
    name: string;
    description: string;
    price: number;
    automaker: string;
    year:number;
    model:string;
    category:string;
}

export interface Car extends Product{
    quilomatragem: number;
    color : string ;
}

export interface Part {
    part_condition: string;
    brand : string;
    vehicle_type :string;
}

export class AnnounceCarClass {
    user!: User;
    amount!: number;
    date!: Date;
    comments?: Comment[];
    product!: CarClass;
    adress !: AdressClass;
}

export class CarClass implements Product{
    id : number = 0;
    name: string = "";
    description: string = "";
    price: number = 0;
    automaker: string = "";
    year: number = 0;
    model: string = "";
    category: string = "";
    quilometragem: number = 0;
    color : string = "";
}

export class UserClass {
    id!: number;
    name!: string;
    email!: string;
    birthDate?: string;
    login?: Login;
    announcementList?: AnnouncementList[];
    nacionalNumber?: string;
    descriminationColumn?: string;
    fone!: string;
    adress?: Adress;
}

export class AdressClass {
    cep?: string;
    logradouro?: string;
    complemento?: string;
    bairro?: string;
    localidade?: string;
    uf?: string;
}