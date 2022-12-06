export interface Roles {
    id: number;
    authority: string;
}

export interface Login {
    username: string;
    password: string;
    roles: Roles[];
}

export interface AnnouncementList {
    id: number;
    amount: number;
    user: User;
    date: string;
    product: Product;
}

export interface Address {
    cep: string;
    logradouro?: string;
    complemento?: string;
    bairro?: string;
    localidade: string;
    uf: string;
    ddd?: string;
}

export interface User {
    id?: number;
    name: string;
    email: string;
    birthDate?: string;
    login?: Login;
    announcementList?: AnnouncementList[];
    nacionalNumber?: string;
    descriminationColumn?: string;
    fone: string;
    address?: Address;
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

export interface Images{
    id ?: number
    name ?: string
}

export interface Announce {
    id: number;
    user: User;
    amount: number;
    date: Date;
    comments?: Comment[];
    product: Product;
    address: Address;
    image : Images
}

export interface Product {
    id: number;
    name: string;
    description: string;
    price: number;
    year:number;
    model:string;
    category:string;
}

export interface Car extends Product{
    quilometragem: number;
    color : string ;
    automaker:string;
}

export interface Part extends Product{
    part_condition: string;
    brand : string;
    vehicle_type :string;
    amount : number;
    partmaker:string;
}

export class Images{
    id ?: number
    name ?: string
}

export class AnnounceCarClass {
    user!: User;
    amount!: number;
    date!: Date;
    comments?: Comment[];
    product!: CarClass;
    adress !: AdressClass;
    image!: Images;
}

export class AnnouncePartClass {
    user!: User;
    amount!: number;
    date!: Date;
    comments?: Comment[];
    product!: PartClass;
    adress !: AdressClass;
    image!: Images;
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

export class PartClass implements Product {
    id : number = 0;
    name: string = "";
    description: string = "";
    price: number = 0;
    partmaker: string = "";
    year: number = 0;
    model: string = "";
    category: string = "";
    part_condition: string = "";
    brand : string = "";
    vehicle_type :string = "";
    amount : number = 0;
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
    adress?: Address;
}

export class AdressClass {
    cep?: string;
    logradouro?: string;
    complemento?: string;
    bairro?: string;
    localidade?: string;
    uf?: string;
}
