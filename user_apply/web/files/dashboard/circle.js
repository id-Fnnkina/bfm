/**
 * Created by admin on 2019/1/15.
 */
//���Ʊ�ͼ
function drawCircle(canvasId, data_arr, color_arr, text_arr)
{
    var c = document.getElementById(canvasId);
    var ctx = c.getContext("2d");

    var radius = c.height / 2 - 20; //�뾶
    var ox = radius + 20, oy = radius + 20; //Բ��

    var width = 30, height = 10; //ͼ����͸�
    var posX = ox * 2 + 20, posY = 30;   //
    var textX = posX + width + 5, textY = posY + 10;

    var startAngle = 0; //��ʼ����
    var endAngle = 0;   //��������
    for (var i = 0; i < data_arr.length; i++)
    {
        //���Ʊ�ͼ
        endAngle = endAngle + data_arr[i] * Math.PI * 2; //��������
        ctx.fillStyle = color_arr[i];
        ctx.beginPath();
        ctx.moveTo(ox, oy); //�ƶ�����Բ��
        ctx.arc(ox, oy, radius, startAngle, endAngle, false);
        ctx.closePath();
        ctx.fill();
        startAngle = endAngle; //������ʼ����

        //���Ʊ���ͼ������
        ctx.fillStyle = color_arr[i];
        ctx.fillRect(posX, posY + 20 * i, width, height);
        ctx.moveTo(posX, posY + 20 * i);
        ctx.font = 'bold 12px ΢���ź�';    //б�� 30���� ΢���ź�����
        ctx.fillStyle = color_arr[i]; //"#000000";
        var percent = text_arr[i] + "��" +"\t\t"+ 100 * data_arr[i] + "%";
        ctx.fillText(percent+"jk", textX, textY + 20 * i);
    }
}

function init() {
    //���Ʊ�ͼ
    //�������ݺ���ɫ
    var data_arr = [0.1,0.2, 0.3, 0.3,0.1];
    var color_arr = ["BLUE",'RED','YELLOW','GREEN',"Black"];
    var text_arr = ["��һ����", "�ڶ�����", "��������", "���ļ���"];

    drawCircle("canvas_circle", data_arr, color_arr, text_arr);
}

//ҳ�����ʱִ��init()����
window.onload = init;