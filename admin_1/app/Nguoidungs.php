<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Notifications\Notifiable;
use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Foundation\Auth\User as Authenticatable;
class Nguoidungs extends Authenticatable
{
    use Notifiable;
    public function getAuthPassword(){
        return $this->matkhau;
    }
    protected $table="nguoidungs";
    public $timestamps=false;
    protected $fillable=[
        'gmail',
        'matkhau',
        'phanquyen',
        'ten',
        'action',
    ];
    protected $hidden = [
        'password', 'remember_token',
    ];
}
