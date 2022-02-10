// /**
//  *
//  * */
//
// $(document).ready(function () {
//     loadResumeInformation();
//     //Добавление нового юзера
//     $('.AddBtn').on('click', function (event) {
//         event.preventDefault();
//         let user = {
//             name: $('#name').val(),
//             login: $('#login').val(),
//             password: $('#password').val(),
//             roles: ["USER"]
//         };
//         console.log(user);
//         fetch('/save', {
//
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json;charset=utf-8'
//             },
//             body: JSON.stringify(user),
//         }).then(() => {
//             window.location.replace('/all_resume')
//         });
//         $('input').val('');
//     });
//
//     $('.SaveResume').on('click', function (event) {
//         event.preventDefault();
//
//         const formData = new FormData();
//         const photos = document.getElementById("exampleFormControlFile1");
//
//         formData.append("multipartImage", photos.files[0])
//
//
//         fetch('/image/save', {
//             method: 'POST',
//             body: formData
//         });
//
//
//         let resume = {
//             age: $('#age').val(),
//             first_name: $('#first_name').val(),
//             last_name: $('#last_name').val(),
//             education: $('#education').val(),
//             experience: $('#experience').val(),
//             skills: $('#skills').val(),
//             about: $('#about').val(),
//             visibility: validate()
//         };
//
//         function validate() {
//             if (document.getElementById('flexCheckDefault').checked) {
//                 return true;
//             } else {
//                 return false;
//             }
//         }
//         // console.log(resume);
//         fetch('/resume', {
//
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json;charset=utf-8'
//             },
//             body: JSON.stringify(resume),
//
//         }).then(() => {
//             //window.location.replace('/all_resume')
//         });
//
//
//     });
//
//     fetch('/resume/myResume').then(result => result.json()
//         .then(data => obj = data)
//         .then(() => {
//             // document.getElementById("ageOutPut").textContent += obj.age;
//             // document.getElementById("firstNameOutPut").textContent += obj.first_name;
//             // document.getElementById("lastNameOutPut").textContent += obj.last_name;
//             // document.getElementById("educationOutPut").textContent += obj.education;
//             // document.getElementById("experienceOutPut").textContent += obj.experience;
//             // document.getElementById("skillsOutPut").textContent += obj.skills;
//             // document.getElementById("aboutOutPut").textContent += obj.about;
//             // document.getElementById("visibilityOutPut").textContent += obj.visibility;
//
//
//             document.getElementById("age").value = obj.age;
//             document.getElementById("first_name").value = obj.first_name;
//             document.getElementById("last_name").value = obj.last_name;
//             document.getElementById("education").value = obj.education;
//             document.getElementById("experience").value = obj.experience;
//             document.getElementById("skills").value = obj.skills;
//             document.getElementById("about").value = obj.about;
//
//         }));
//
//
//
//     function loadResumeInformation() {
//
//         let ResumeTableBody = $("#resume_table_body");
//         ResumeTableBody.children().remove();
//         fetch('resume/allPublishedResume')
//             .then((response) => {
//                 response.json().then(data => data.forEach(function (item, i, data) {
//                     //Создание строки с данными юзера
//                     let TableRow = createTableRow(item);
//                     ResumeTableBody.append(TableRow);
//
//                    // Удаление юзера и столбца таблицы
//                     $('.eBtnDel').on('click', function (event) {
//                         event.preventDefault();
//                         let href = $(this).attr('href');
//                         let id = $(this).attr('id');
//                         console.log(id);
//                         fetch(href, {method: 'DELETE'})
//                             .then(result => console.log(result))
//                             .then(() => loadResumeInformation())
//                     });
//
//                 }));
//             }).catch(error => {
//             console.log(error);
//         });
//     }
//
//     function createTableRow(r) {
//
//         return `<tr id="resume_table_row_${r.id}">
//                 <td>${r.first_name}</td>
//                 <td>${r.last_name}</td>
//                 <td>${r.education}</td>
//                 <td>${r.experience}</td>
//                 <td>${r.skills}</td>
//                 <td>${r.about}</td>
//                 <td>${r.visibility}</td>
//                 <td>
//                 <a id="${r.id}" href="/resume/delete/${r.id}" class="btn btn-danger eBtnDel">Delete</a>
//                 </td>
//             </tr>`;
//     }
// });
//
//
//
//
//
