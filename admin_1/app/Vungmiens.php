<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
class Vungmiens extends Model
{
    protected $table="vungmiens";
    public $timestamps=false;
    protected $fillable=[
        'ten_vungmien',
        'noidung',
        'action',
        'created_at',
        'updated_at',
    ];
    public function baiviets(){
        return $this->hasmany('App\baiviets');
    }
}
