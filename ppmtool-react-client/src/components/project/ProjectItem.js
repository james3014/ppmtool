import React, { Component } from "react";

class ProjectItem extends Component {
  render() {
    return (
      <div class="container">
        <div class="card card-body bg-light mb-3">
          <div class="row">
            <div class="col-2">
              <span class="mx-auto">REACT</span>
            </div>
            <div class="col-lg-6 col-md-4 col-8">
              <h3>Spring / React Project</h3>
              <p>Project to create a Kanban Board with Spring Boot and React</p>
            </div>
            <div class="col-md-4 d-none d-lg-block">
              <ul class="list-group">
                <a href="#">
                  <li class="list-group-item board">
                    <i class="fa fa-flag-checkered pr-1"> Project Board </i>
                  </li>
                </a>
                <a href="#">
                  <li class="list-group-item update">
                    <i class="fa fa-edit pr-1"> Update Project Info</i>
                  </li>
                </a>
                <a href="">
                  <li class="list-group-item delete">
                    <i class="fa fa-minus-circle pr-1"> Delete Project</i>
                  </li>
                </a>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ProjectItem;
