<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Baiviets extends Model
{
    protected $table="baiviets";
    public $timestamps=false;
    protected $fillable=[
    'ten',
    'chude_id',
    'vungmien_id',
    'nguyenlieu',
    'soche',
    'thuchien',
    'cachdung',
    'action',
    'created_at',
    'updated_at',
    'hinhanh',
];
}
